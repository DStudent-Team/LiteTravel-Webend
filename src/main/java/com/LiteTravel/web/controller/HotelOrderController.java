package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Hotel.HotelRoomSearchDTO;
import com.LiteTravel.web.DTO.HotelOrder.*;
import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.DTO.RoomDTO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.Model.HotelOrder;
import com.LiteTravel.web.Model.HotelOrderDetail;
import com.LiteTravel.web.service.HotelOrderService;
import com.LiteTravel.web.service.HotelService;
import com.LiteTravel.web.service.Utils.MoneyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HotelOrderController {
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelOrderService hotelOrderService;

    @Resource
    private MoneyService moneyService;

    /***
     * 提交订单请求
     * @param submitDTO 请求数据
     * @param model 请求model
     * @return 返回url
     * @throws ParseException
     */
    @PostMapping("/order")
    @Transactional
    public String submitBook(HotelOrderSubmitDTO submitDTO, ModelMap model) throws ParseException {
        /*应该全部整理进service中去*/
        HotelOrderInfoDTO hotelOrderInfoDTO = new HotelOrderInfoDTO();
        hotelOrderInfoDTO.setHotelId(submitDTO.getHotelId());
        hotelOrderInfoDTO.setUserId(submitDTO.getUserId());
        hotelOrderInfoDTO.setHotel(hotelService.selectHotelById(submitDTO.getHotelId(), false, new HotelRoomSearchDTO()));
        hotelOrderInfoDTO.setDetails(hotelService.getHotelOrderDetailByRoomIds(Collections.singletonList(submitDTO.getRoomId())));
        for (HotelOrderDetailDTO detail: hotelOrderInfoDTO.getDetails()){
            detail.setRoomPrice(submitDTO.getPrice());
            detail.setRoomCount(submitDTO.getRoomCount());
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkInDate = dateFormat.parse(submitDTO.getCheckIn());
        Date checkOutDate = dateFormat.parse(submitDTO.getCheckOut());
        hotelOrderInfoDTO.setCheckIn(checkInDate);
        hotelOrderInfoDTO.setCheckOut(checkOutDate);
        //计算时间
        Integer days = (int)((checkOutDate.getTime() - checkInDate.getTime()) / (1000 * 60 * 60 * 24));
        hotelOrderInfoDTO.setDays(days);
        /*总价需重新计算*/
        float total = 0;
        for (HotelOrderDetailDTO detail: hotelOrderInfoDTO.getDetails()) {
            total += detail.getRoomCount() * detail.getRoomPrice();
        }
        hotelOrderInfoDTO.setTotal(total);

        /* 更新时间段剩余房间数 */
        List<Integer> roomRemaining = hotelService.getRemainRooms(checkInDate, checkOutDate, submitDTO.getHotelId(),
                Collections.singletonList(submitDTO.getRoomId()));
        /* lambda语法: foreach, 逐个设置房间剩余数*/
        IntStream.range(0, roomRemaining.size()).forEach(index -> hotelOrderInfoDTO.getDetails().get(index).setRoomRemaining(roomRemaining.get(index)));

        model.addAttribute("order", hotelOrderInfoDTO);
        return "hotel-order";
    }

    @GetMapping("/orders")
    public String OrderList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                            ModelMap model, HttpSession session){
        UserDTO user = (UserDTO) session.getAttribute("user");
        if (user == null){
            model.addAttribute("message", "找不到该用户");
            return "redirect:/login";
        }
        setPageHotelOrder(page, model, user.getUserId());
        return "orders";
    }

    @PostMapping("/orders")
    public String OrderSearchList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  HotelOrderQueryDTO hotelOrderQueryDTO,
                                  ModelMap model, String statusList) {
        //通过变量获取订单状态并在controller并入DTO，直接用DTO存会出现数据累计错误
        hotelOrderQueryDTO.setStatus(statusList);
        setPageHotelOrder(page, hotelOrderQueryDTO, model);
        return "orders";
    }
    /* 使用PageHelper获得并设置 分页数据 */
    private void setPageHotelOrder(Integer page, ModelMap model, Integer userId){
        /* 向service层分发请求处理 */
        ResultVO resultVO = hotelOrderService.getOrders(page, 6, userId);
        /* 分页信息类
         * 参数1：数据集合
         * 参数2：需要展示的最大导航页数*/
        /* 设置筛选页面的筛选项目为Hotel */
        model.addAttribute("category", "hotel");
        /* 放入数据 */
        /* 放入hotel列表数据 */
        model.addAttribute("orders", resultVO.data);
        /* 放入页面信息数据 */
        model.addAttribute("pageInfo", resultVO.info);
    }
    /* 有搜索条件的前提下进行分页 */
    private void setPageHotelOrder(Integer page, HotelOrderQueryDTO hotelOrderQueryDTO, ModelMap model) {
        /* 向service层分发请求处理 */
        ResultVO resultVO = hotelOrderService.getOrders(page, 6, hotelOrderQueryDTO);
        /* 分页信息类
         * 参数1：数据集合
         * 参数2：需要展示的最大导航页数*/
        /* 设置筛选页面的筛选项目为Hotel */
        model.addAttribute("category", "hotel");
        /* 放入数据 */
        /* 放入hotel列表数据 */
        model.addAttribute("orders", resultVO.data);
        /* 放入查询信息数据 */
        model.addAttribute("search", hotelOrderQueryDTO);
        /* 放入页面信息数据 */
        model.addAttribute("pageInfo", resultVO.info);
    }
    @GetMapping("/order/{orderId}")
    public String getHotelOrderInfo(@PathVariable("orderId") Integer orderId, ModelMap model, HttpSession session){
        //额外提供用户余额
        UserDTO user = (UserDTO) session.getAttribute("user");
        model.addAttribute("userMoney", moneyService.getMoney(user.getUserId()));

        HotelOrderInfoDTO hotelOrderInfoDTO = hotelOrderService.getHotelOrderInfoById(orderId);
        hotelOrderInfoDTO.setHotel(hotelService.selectHotelById(hotelOrderInfoDTO.getHotelId(), false , new HotelRoomSearchDTO()));
        hotelOrderInfoDTO.setDetails(hotelOrderInfoDTO.getDetails().stream().peek(hotelOrderDetailDTO -> {
            RoomDTO roomDTO = hotelService.getRoomDTO(hotelOrderDetailDTO.getRoomId());
            hotelOrderDetailDTO.setRoomName(roomDTO.getRoomName());
            hotelOrderDetailDTO.setRoomWifi(roomDTO.getRoomWifi());
            hotelOrderDetailDTO.setBeds(roomDTO.getBeds());

        }).collect(Collectors.toList()));
        System.out.println(hotelOrderInfoDTO.toString());
        model.addAttribute("order", hotelOrderInfoDTO);
        return "order";
    }

    @PostMapping ("/order/cancel")
    public String deleteOrder(Integer orderId, ModelMap model){
        hotelOrderService.deleteOrder(orderId);
        model.addAttribute("message", "取消成功");
        return "redirect:/orders";

    }

    @PostMapping("/order/pay")
    public String transaction(OrderTransactionDTO orderTransactionDTO, Model model){

        //通过hotelId找到managerId
        Integer managerId = hotelService.findManagerIdByHotelId(orderTransactionDTO.getHotelId());
        if (managerId == -1){
            model.addAttribute("message", "没有这个用户");
            return "redirect:/orders";
        }else{
            boolean flag = moneyService.transaction(orderTransactionDTO.getUserId(), managerId, orderTransactionDTO.getMoney(), orderTransactionDTO.getUserPassword());
            if (!flag){
                model.addAttribute("message", "交易失败");
                return "redirect:/order/"+orderTransactionDTO.getOrderId();
            }else{
                hotelOrderService.updateHotelOrder(orderTransactionDTO.getOrderId());
                model.addAttribute("message", "交易成功");
                return "redirect:/order/"+orderTransactionDTO.getOrderId();
            }
        }
    }

    /**
     * 在发起订单页面 确认订单信息并提交酒店订单业务，申请新订单
     */
    @PostMapping("/book/submit")
    @ResponseBody
    public ResponseDTO bookHotel(@RequestBody HotelOrderConfirmDTO hotelOrderConfirmDTO){
        //生成订单信息，成功则跳转至订单页面
        HotelOrder hotelOrder = new HotelOrder();
        BeanUtils.copyProperties(hotelOrderConfirmDTO, hotelOrder);
        hotelOrder.setStatus("0");
        hotelOrder.setCreateDate(new Date());
        System.out.println(hotelOrder.toString());
        List<HotelOrderDetail> hotelOrderDetails = new ArrayList<>();
        for (HotelOrderDetailDTO roomOrder:hotelOrderConfirmDTO.getRooms()) {
            HotelOrderDetail hotelOrderDetail = new HotelOrderDetail();
            BeanUtils.copyProperties(roomOrder, hotelOrderDetail);
            System.out.println(hotelOrderDetail.toString());
            hotelOrderDetails.add(hotelOrderDetail);
        }
        /*插入新数据*/
        Integer orderId = hotelOrderService.insertHotelOrder(hotelOrder, hotelOrderDetails);

        return ResponseDTO.success(orderId);
    }

    @PostMapping("/order/unPay")
    public String unTransaction(OrderTransactionDTO orderTransactionDTO, Model model){

        //通过hotelId找到managerId
        Integer managerId = hotelService.findManagerIdByHotelId(orderTransactionDTO.getHotelId());
        if (managerId == -1){
            model.addAttribute("message", "没有这个用户");
            return "redirect:/login";
        }else{
            moneyService.unTransaction(orderTransactionDTO.getUserId(), managerId, orderTransactionDTO.getMoney());
            hotelOrderService.updateHotelOrderStatus(orderTransactionDTO.getOrderId(), "0");
            model.addAttribute("message", "退款成功");
            return "redirect:/orders";
        }
    }
}

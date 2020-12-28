package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.HotelOrder.DisplayOrderCommentDTO;
import com.LiteTravel.web.DTO.HotelOrder.OrderCommentDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.OrderComment;
import com.LiteTravel.web.Model.OrderCommentExample;
import com.LiteTravel.web.mapper.OrderCommentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiaobai
 * @Date 2020/12/26 20:13
 * @Version 1.0
 */
@Service
public class OrderCommentService {
    @Resource
    private OrderCommentMapper orderCommentMapper;

    /**
     * 保存用户评价
     * @param orderCommentDTO 评价信息
     * @return int
     */
    public int saveOrderComment(OrderCommentDTO orderCommentDTO, String username){
        OrderComment orderComment = new OrderComment();

        orderComment.setUserName(username);
        orderComment.setHotelId(orderCommentDTO.getHotelId());
        orderComment.setOrderId(orderCommentDTO.getOrderId());
        orderComment.setOcScore(orderCommentDTO.getScore());
        orderComment.setOcDetail(orderCommentDTO.getDetail());

        return orderCommentMapper.insertSelective(orderComment);
    }

    /**
     * 通过hotelId查找所有评价信息
     * @param hotelId hotelId
     * @return int
     */
    public ResultVO listOrderCommentsByHotelId(Integer hotelId, Integer pageNum, Integer pageSize) {

        OrderCommentExample orderCommentExample = new OrderCommentExample();
        orderCommentExample.createCriteria().andHotelIdEqualTo(hotelId);
        PageHelper.startPage(pageNum, pageSize);
        List<OrderComment> orderComments = orderCommentMapper.selectByExample(orderCommentExample);
        PageInfo<OrderComment> pageInfo = new PageInfo<>(orderComments, 5);
        List<DisplayOrderCommentDTO> displayOrderCommentDTOS = listDisplayOrderComment(orderComments);

        return new ResultVO(displayOrderCommentDTOS,pageInfo);
    }

    /**
     * 根据商家的id删除所有评价
     * @param hotelId 商家id
     * @return int
     */
    public int deleteOrderCommentsByHotelId(Integer hotelId){
        OrderCommentExample orderCommentExample = new OrderCommentExample();
        orderCommentExample.createCriteria().andHotelIdEqualTo(hotelId);
        return orderCommentMapper.deleteByExample(orderCommentExample);
    }

    /**
     * 将List<OrderComment> orderComments转为 List<DisplayOrderCommentDTO>
     * @param orderComments List<OrderComment> orderComments
     * @return List<DisplayOrderCommentDTO>
     */
    private List<DisplayOrderCommentDTO> listDisplayOrderComment(List<OrderComment> orderComments){
        List<DisplayOrderCommentDTO> displayOrderCommentDTOS = new ArrayList<>();
        for (OrderComment orderComment : orderComments){
            displayOrderCommentDTOS.add(new DisplayOrderCommentDTO(orderComment.getUserName(), orderComment.getOcScore(), orderComment.getOcDetail()));
        }
        return displayOrderCommentDTOS;
    }
}

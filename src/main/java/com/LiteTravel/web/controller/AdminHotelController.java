package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.BedDTO;
import com.LiteTravel.web.DTO.HotelDTO;
import com.LiteTravel.web.DTO.RoomDTO;
import com.LiteTravel.web.Model.Bed;
import com.LiteTravel.web.Model.Hotel;
import com.LiteTravel.web.Model.RoomBedMap;
import com.LiteTravel.web.service.HotelService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminHotelController {

    @Autowired
    public HotelService hotelService;

    /*-----------------------------------------------------------------------------*/
    /*酒店增删改方法*/
    @PostMapping("/manage/hotel")
    public String insertOrUpdateHotel(HotelDTO hotelDTO){
        //通过检索id值是否为空判断是insert还是update,返回值0表示insert，1是update
        int i = hotelService.checkHotelId(hotelDTO);
        if(i == 0){

            /*插入酒店信息,checkHotelByName()是查询是否存在此酒店，存在则不能插入*/
            List<Hotel> hotel = hotelService.checkHotelByName(hotelDTO);
            if(hotel.size() > 0){
                //数据库中存在酒店，不可添加
                System.out.println("酒店已存在！");
            }
            else{
                hotelService.insertHotel(hotelDTO);
            }
        }
        else{

            /*更新酒店信息*/
            int result = hotelService.updateHotel(hotelDTO);
            if(result == 0){
                System.out.println("修改失败");
            }
        }
        return "redirect:/manage/hotels";
    }

    //delete
    @DeleteMapping("/manage/hotel/{hotelId}")
    public String deleteHotel(@PathVariable("hotelId") Integer hotelId){

        hotelService.deleteHotel(hotelId);
        return "redirect:/manage/hotels";
    }

    /*-----------------------------------------------------------------------------*/
    /*酒店房间增删改*/
    //delete
    @DeleteMapping("/manage/room/{roomId}")
    public String deleteRoom(@PathVariable("roomId") Integer roomId){

        hotelService.deleteRoom(roomId);
        return "redirect:/manage/rooms";
    }

    //updata and insert
    @PostMapping("/manage/room")
    public String insertOrUpdateRoom(RoomDTO roomDTO){
        //通过检索id值是否为空判断是insert还是update,返回值0表示insert，1是update
        //检查是删除还是更新
        if(hotelService.checkRoomId(roomDTO)==0 ){
            /*是插入数据*/
            hotelService.insertRoom(roomDTO);
        }
        else {
            hotelService.updateRoom(roomDTO);
        }
        return "redirect:/manage/rooms";
    }
    /*---------------------------------------------*/
    /*房间床位*/
    /*从床位管理返回Rooms菜单*/
    @PostMapping("manage/turnBackRooms")
    public String turnBackRooms(){
        return "redirect:/manage/rooms";
    }

    /*删除酒店床位*/
    @PostMapping("manage/roomBed/delete")
    public String deleteRoomBed(BedDTO bedDTO,ModelMap model,HttpSession session,
                                @RequestParam(value = "page", defaultValue = "1")Integer page) {
        hotelService.deleteRoomBed(bedDTO);
        //bedCount 数值是 roomId
        hotelService.getRoomBeds(page, 6, bedDTO.getBedCount(),model,session);
        return "room/roomBed";
    }
    //添加酒店床位
    @PostMapping("manage/roomBed/insert")
    public String insertRoomBed(BedDTO bedDTO,ModelMap model,HttpSession session,
                                @RequestParam(value = "page", defaultValue = "1")Integer page){
        //将bedId当做roomId，所以getBedId其实是getRoomId
        hotelService.insertRoomBed(bedDTO);
        //BedId 保存的是 roomId
        hotelService.getRoomBeds(page, 6, bedDTO.getBedId(),model,session);
        return "room/roomBed";
    }
    /*-----------------------------------------------------------------------------*/
    /*床位增删改*/
    @PostMapping("/manage/bed")
    public String insertOrUpdateBed(BedDTO bedDTO){
        Bed bed = new Bed();
        BeanUtils.copyProperties(bedDTO, bed);
        if(bed.getBedId() == null){
            hotelService.insertBed(bed);
        }
        else{
            hotelService.updateBed(bed);
        }
        return "redirect:/manage/beds";
    }

    @DeleteMapping("manage/bed/{bedId}")
    public String deleteBed(@PathVariable("bedId") Integer bedId) {
        hotelService.deleteBed(bedId);
        return "redirect:/manage/beds";
    }
}

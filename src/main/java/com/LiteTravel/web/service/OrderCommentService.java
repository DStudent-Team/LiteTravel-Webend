package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.HotelOrder.OrderCommentDTO;
import com.LiteTravel.web.Model.OrderComment;
import com.LiteTravel.web.Model.OrderCommentExample;
import com.LiteTravel.web.mapper.OrderCommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public int saveOrderComment(OrderCommentDTO orderCommentDTO){
        OrderComment orderComment = new OrderComment();

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
    public List<OrderComment> listOrderCommentsByHotelId(Integer hotelId) {
        OrderCommentExample orderCommentExample = new OrderCommentExample();
        orderCommentExample.createCriteria().andHotelIdEqualTo(hotelId);
        return orderCommentMapper.selectByExample(orderCommentExample);
    }
}

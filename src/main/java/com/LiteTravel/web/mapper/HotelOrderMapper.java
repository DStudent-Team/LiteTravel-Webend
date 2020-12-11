package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.HotelOrder;
import com.LiteTravel.web.Model.HotelOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    long countByExample(HotelOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int deleteByExample(HotelOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int insert(HotelOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int insertSelective(HotelOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    List<HotelOrder> selectByExampleWithBLOBs(HotelOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    List<HotelOrder> selectByExample(HotelOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    HotelOrder selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int updateByExampleSelective(@Param("record") HotelOrder record, @Param("example") HotelOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") HotelOrder record, @Param("example") HotelOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int updateByExample(@Param("record") HotelOrder record, @Param("example") HotelOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int updateByPrimaryKeySelective(HotelOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(HotelOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel_orders
     *
     * @mbg.generated Thu Dec 10 23:46:40 CST 2020
     */
    int updateByPrimaryKey(HotelOrder record);
}
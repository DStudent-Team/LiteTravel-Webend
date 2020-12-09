package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.Hotel;
import com.LiteTravel.web.Model.HotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    long countByExample(HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int deleteByExample(HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int deleteByPrimaryKey(Integer hotelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int insert(Hotel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int insertSelective(Hotel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    List<Hotel> selectByExampleWithBLOBs(HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    List<Hotel> selectByExample(HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    Hotel selectByPrimaryKey(Integer hotelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int updateByExampleSelective(@Param("record") Hotel record, @Param("example") HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Hotel record, @Param("example") HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int updateByExample(@Param("record") Hotel record, @Param("example") HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int updateByPrimaryKeySelective(Hotel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Hotel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_hotel
     *
     * @mbg.generated Wed Dec 09 00:13:45 CST 2020
     */
    int updateByPrimaryKey(Hotel record);
}
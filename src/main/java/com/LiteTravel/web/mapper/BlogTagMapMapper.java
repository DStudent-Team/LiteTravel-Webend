package com.LiteTravel.web.mapper;

import com.LiteTravel.web.Model.BlogTagMap;
import com.LiteTravel.web.Model.BlogTagMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface                                                                                                                                                                                                                                                                                                                          BlogTagMapMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_blog_tags
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    long countByExample(BlogTagMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_blog_tags
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    int deleteByExample(BlogTagMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_blog_tags
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    int insert(BlogTagMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_blog_tags
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    int insertSelective(BlogTagMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_blog_tags
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    List<BlogTagMap> selectByExample(BlogTagMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_blog_tags
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    int updateByExampleSelective(@Param("record") BlogTagMap record, @Param("example") BlogTagMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table travel_blog_tags
     *
     * @mbg.generated Sun Dec 20 18:24:28 CST 2020
     */
    int updateByExample(@Param("record") BlogTagMap record, @Param("example") BlogTagMapExample example);
}
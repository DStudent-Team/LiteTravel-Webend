package com.LiteTravel.web.Model;

import java.util.Date;

public class transaction {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_transaction.transaction_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Integer transactionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_transaction.buyer_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Integer buyerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_transaction.seller_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Integer sellerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_transaction.money
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Float money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column travel_transaction.create_time
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_transaction.transaction_id
     *
     * @return the value of travel_transaction.transaction_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Integer getTransactionId() {
        return transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_transaction.transaction_id
     *
     * @param transactionId the value for travel_transaction.transaction_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_transaction.buyer_id
     *
     * @return the value of travel_transaction.buyer_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Integer getBuyerId() {
        return buyerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_transaction.buyer_id
     *
     * @param buyerId the value for travel_transaction.buyer_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_transaction.seller_id
     *
     * @return the value of travel_transaction.seller_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Integer getSellerId() {
        return sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_transaction.seller_id
     *
     * @param sellerId the value for travel_transaction.seller_id
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_transaction.money
     *
     * @return the value of travel_transaction.money
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Float getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_transaction.money
     *
     * @param money the value for travel_transaction.money
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setMoney(Float money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column travel_transaction.create_time
     *
     * @return the value of travel_transaction.create_time
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column travel_transaction.create_time
     *
     * @param createTime the value for travel_transaction.create_time
     *
     * @mbg.generated Sun Dec 20 16:52:53 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
package com.LiteTravel.web.service.Utils;

import com.LiteTravel.web.Model.Transaction;
import com.LiteTravel.web.Model.UserMoney;
import com.LiteTravel.web.mapper.TransactionMapper;
import com.LiteTravel.web.mapper.UserMoneyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @author xiaobai
 */
@Service
public class MoneyService {

    /***
     * 支付记录处理, 增删查
     *
     * 转账处理
     *
     */
    @Resource
    private UserMoneyMapper moneyMapper;

    @Resource
    private TransactionMapper transactionMapper;

    /**
     * 通过userId查找钱
     * @param userId
     * @return
     */
    public float getMoney(int userId){
        if (hasUser(userId)){
            return moneyMapper.selectByPrimaryKey(userId).getMoney();
        }
        return 0;
    }

    /**
     * 加钱或更新钱
     * @param userId userId
     * @param money 钱
     */
    public void insertMoney(int userId, float money){
        UserMoney uMoney = new UserMoney();
        if (hasUser(userId)){
             uMoney.setMoney(getMoney(userId) + money);
             uMoney.setUserId(userId);
             moneyMapper.updateByPrimaryKeySelective(uMoney);
        }
        else{
            uMoney.setUserId(userId);
            uMoney.setMoney(money);
            moneyMapper.insertSelective(uMoney);
        }
    }

    /**
     * 有没有充过钱
     * @param userId 用户id
     * @return boolean
     */
    public boolean hasUser(int userId){
        return moneyMapper.selectByPrimaryKey(userId) != null;
    }

    /**
     * 模拟交易
     * @param userId 用户id
     * @param adminId 商家id
     * @param money 交易金额
     * @return 是否成功
     */
    public boolean transaction(int userId, int adminId, float money){
        UserMoney uMoney = new UserMoney();
        float um = 0;
        // 用户可能空账号
        if (!hasUser(userId)){
            uMoney.setUserId(userId);
            uMoney.setMoney(0.0f);
            moneyMapper.insertSelective(uMoney);
            return false;
        }
        else{
            um = getMoney(userId);
            if (um < money){
                return false;
            }
        }
        // 管理员很可能空账号
        if (!hasUser(adminId)){
            uMoney.setUserId(adminId);
            uMoney.setMoney(0.0f);
            moneyMapper.insertSelective(uMoney);
        }
        //交易
        synchronized (this){
            //-money
            uMoney.setUserId(userId);
            uMoney.setMoney(um - money);
            moneyMapper.updateByPrimaryKeySelective(uMoney);
            //+money
            uMoney.setUserId(adminId);
            uMoney.setMoney(getMoney(adminId) + money);
            moneyMapper.updateByPrimaryKeySelective(uMoney);
            //记录交易
            Transaction transaction = new Transaction();
            transaction.setSellerId(adminId);
            transaction.setBuyerId(userId);
            transaction.setMoney(money);
            transaction.setCreateTime(new Date());
            transactionMapper.insertSelective(transaction);
        }
        return true;
    }
}

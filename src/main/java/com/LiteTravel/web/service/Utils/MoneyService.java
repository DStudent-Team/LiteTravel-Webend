package com.LiteTravel.web.service.Utils;

import com.LiteTravel.web.Model.userMoney;
import com.LiteTravel.web.mapper.userMoneyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


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
    private userMoneyMapper moneyMapper;

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
        userMoney uMoney = new userMoney();
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
     * @return 提示信息
     */
    public String transaction(int userId, int adminId, float money){
        userMoney uMoney = new userMoney();
        float um = 0;
        // 用户可能空账号
        if (!hasUser(userId)){
            uMoney.setUserId(userId);
            uMoney.setMoney(0.0f);
            moneyMapper.insertSelective(uMoney);
            return "没钱啊";
        }
        else{
            um = getMoney(userId);
            if (um < money){
                return "不够钱";
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
        }
        return "交易成功";
    }
}

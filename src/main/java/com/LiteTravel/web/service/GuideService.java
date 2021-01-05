package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.Guide.GuideDTO;
import com.LiteTravel.web.DTO.Guide.GuideSearchDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.Guide;
import com.LiteTravel.web.Model.GuideExample;
import com.LiteTravel.web.mapper.GuideMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GuideService {
    @Resource
    GuideMapper guideMapper;

    public ResultVO getGuides(GuideSearchDTO guideSearchDTO){
        PageHelper.startPage(1, 5);
        List<Guide> guides = guideMapper.selectByExample(getGuideExample(guideSearchDTO));
        PageInfo<Guide> pageInfo = new PageInfo<>(guides, 5);
        return new ResultVO(guides, pageInfo);
    }

    private GuideExample getGuideExample(GuideSearchDTO guideSearchDTO){
        GuideExample guideExample = new GuideExample();
        GuideExample.Criteria criteria = guideExample.createCriteria();
        Integer userId = guideSearchDTO.getUserId();
        if (userId != null){
            criteria.andUserIdEqualTo(userId);
        }
        guideExample.setOrderByClause("create_time DESC");
        return guideExample;
    }

    public void insertGuide(GuideDTO guideDTO){
        Guide guide = new Guide();
        BeanUtils.copyProperties(guideDTO, guide);
        /* 先看看原本有没有查过, 如果有那就不要浪费存储空间? */
        GuideExample guideExample = new GuideExample();
        guideExample.createCriteria()
                .andUserIdEqualTo(guide.getUserId())
                .andGuideFromEqualTo(guide.getGuideFrom())
                .andGuideToEqualTo(guide.getGuideTo());
        List<Guide> sameGuides = guideMapper.selectByExample(guideExample);
        if (sameGuides.size() <= 0){
            guide.setCreateTime(new Date());
            guideMapper.insert(guide);
        }
        else {
            guide.setGuideId(sameGuides.get(0).getGuideId());
            guide.setCreateTime(new Date());
            guideMapper.updateByPrimaryKeySelective(guide);
        }
    }

}

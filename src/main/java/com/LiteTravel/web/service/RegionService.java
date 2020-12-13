package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.Region.RegionDTO;
import com.LiteTravel.web.DTO.Region.RegionSearchDTO;
import com.LiteTravel.web.Model.Region;
import com.LiteTravel.web.Model.RegionExample;
import com.LiteTravel.web.mapper.RegionMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionService {
    @Autowired
    RegionMapper regionMapper;
    /*不分页的全部数据*/
    public List<RegionDTO> searchRegion(RegionSearchDTO regionSearchDTO){
        return selectByExample(getExample(regionSearchDTO));
    }

    private List<RegionDTO> selectByExample(RegionExample regionExample){
        List<Region> regions = regionMapper.selectByExample(regionExample);
        return regions.stream().map(region -> {
            RegionDTO regionDTO = new RegionDTO();
            BeanUtils.copyProperties(region, regionDTO);
            return regionDTO;
        }).collect(Collectors.toList());
    }

    private RegionExample getExample(RegionSearchDTO regionSearchDTO){
        RegionExample regionExample = new RegionExample();
        RegionExample.Criteria regionCriteria = regionExample.createCriteria();
        Integer regionId = regionSearchDTO.getRegionId();
        Integer regionLevel = regionSearchDTO.getRegionLevel();
        Integer regionParentId = regionSearchDTO.getRegionParentId();
        if (regionId != null){
            regionCriteria.andIdEqualTo(regionId);
        }
        if (regionLevel != null){
            regionCriteria.andLevelEqualTo(regionLevel);
        }
        if (regionParentId != null){
            regionCriteria.andPidEqualTo(regionParentId);
        }
        regionExample.setOrderByClause("`id` ASC");
        return regionExample;
    }

}

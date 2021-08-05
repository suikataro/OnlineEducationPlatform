package com.learning.edu.ad.remote;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learning.edu.ad.entity.PromotionSpace;
import com.learning.edu.ad.entity.PromotionAd;
import com.learning.edu.ad.service.IPromotionAdService;
import com.learning.edu.ad.service.IPromotionSpaceService;
import com.learning.edu.dto.PromotionAdDTO;
import com.learning.edu.dto.PromotionSpaceDTO;
import com.learning.edu.remote.AdRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.edu.util.ConvertUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//replace controller
@RestController
@RequestMapping("/ad")
public class AdRemoteServiceImpl implements AdRemoteService {
    @Autowired
    private IPromotionSpaceService promotionSpaceService;

    @Autowired
    private IPromotionAdService promotionAdService;

    @GetMapping("/space/getAllSpaces")
    public List<PromotionSpaceDTO> getAllSpaces() {
        List<PromotionSpace> promotionSpaceList = promotionSpaceService.list();
        return ConvertUtil.convertList(promotionSpaceList,PromotionSpaceDTO.class);
    }

    @GetMapping("/getAdBySpaceKey")
    public List<PromotionSpaceDTO> getAdBySpaceKey(String[] spaceKey) {

        List<PromotionSpaceDTO> promotionSpaceDTOList = new ArrayList<>();

        for (String key : spaceKey) {
            //获取spaceKey对应的广告位
            QueryWrapper<PromotionSpace> spaceQueryWrapper = new QueryWrapper<>();
            spaceQueryWrapper.eq("spaceKey",key);
            PromotionSpace promotionSpace = promotionSpaceService.getOne(spaceQueryWrapper);

            //获取该space对应的所有的广告
            QueryWrapper<PromotionAd> adQueryWrapper = new QueryWrapper<>();
            adQueryWrapper.eq("spaceId",promotionSpace.getId());
            //状态为上线状态
            adQueryWrapper.eq("status",1);
            //有效期内
            Date now = new Date();
            //lt是小于,列的值小于具体的值now
            adQueryWrapper.lt("startTime",now);
            adQueryWrapper.gt("endTime",now);

            List<PromotionAd> adList = promotionAdService.list(adQueryWrapper);
            //属性拷贝
            PromotionSpaceDTO promotionSpaceDTO = ConvertUtil.convert(promotionSpace, PromotionSpaceDTO.class);
            //adlist转换为AdDTOList
            List<PromotionAdDTO> promotionAdDTOList = ConvertUtil.convertList(adList, PromotionAdDTO.class);
            promotionSpaceDTO.setAdDTOList(promotionAdDTOList);

            promotionSpaceDTOList.add(promotionSpaceDTO);
        }

        return promotionSpaceDTOList;
    }
}

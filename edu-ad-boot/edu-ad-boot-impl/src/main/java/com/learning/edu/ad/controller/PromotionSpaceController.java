package com.learning.edu.ad.controller;


import com.learning.edu.ad.entity.PromotionSpace;
import com.learning.edu.ad.service.IPromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Qianhui Fan
 * @since 2021-07-29
 */
//this controller is replaced by remote
//@RestController
//@RequestMapping("/ad/space")
public class PromotionSpaceController {
    @Autowired
    private IPromotionSpaceService promotionSpaceService;

    //@RestController will convert to json
    @RequestMapping("/getAllSpaces")
    public List<PromotionSpace> getAllSpaces(){
        List<PromotionSpace> spaceList = promotionSpaceService.list();
        return spaceList;
    }
}

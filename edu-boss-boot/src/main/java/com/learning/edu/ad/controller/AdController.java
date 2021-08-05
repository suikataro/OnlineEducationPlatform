package com.learning.edu.ad.controller;

import com.learning.edu.dto.PromotionAdDTO;
import com.learning.edu.dto.PromotionSpaceDTO;
import com.learning.edu.remote.AdRemoteService;
import com.learning.edu.resonse.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ad")
public class AdController {
    @Autowired
    private AdRemoteService adRemoteService;

    //接口的统一返回值类型是ResponseDTO
    @RequestMapping("/space/getAllSpaces")
    public ResponseDTO getAllSpace() throws Exception{
        List<PromotionSpaceDTO> dtoList = adRemoteService.getAllSpaces();
        return ResponseDTO.success(dtoList);
    }

    @PostMapping("/space/saveOrUpdateSpace")
    public ResponseDTO saveOrUpdateSpace(@RequestBody PromotionSpaceDTO spaceDTO){
        ResponseDTO responseDTO = adRemoteService.saveOrUpdateSpace(spaceDTO);
        return responseDTO;
    }

    //search from edu-ad-boot
    @GetMapping("/space/getSpaceById")
    public ResponseDTO getSpaceById(@RequestParam("id") Integer id){
        PromotionSpaceDTO spaceDTO = adRemoteService.getSpaceById(id);
        return ResponseDTO.success(spaceDTO);
    }

    @GetMapping("/getAllAds")
    public ResponseDTO getAllAds(){
        List<PromotionAdDTO> adDTOList =adRemoteService.getAllAds();
        return ResponseDTO.success(adDTOList);
    }

    @PostMapping("/saveOrUpdateAd")
    public ResponseDTO saveOrUpdateAd(@RequestBody PromotionAdDTO adDTO){
        ResponseDTO responseDTO = adRemoteService.saveOrUpdateAd(adDTO);
        return ResponseDTO.success(responseDTO);
    }

    @GetMapping("/getAdById")
    public ResponseDTO getAdById(@RequestParam("id") Integer id){
        PromotionAdDTO promotionAdDTO = adRemoteService.getAdById(id);
        return ResponseDTO.success(promotionAdDTO);
    }
}

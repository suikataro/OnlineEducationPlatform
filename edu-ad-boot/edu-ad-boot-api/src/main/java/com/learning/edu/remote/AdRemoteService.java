package com.learning.edu.remote;

import com.learning.edu.dto.PromotionAdDTO;
import com.learning.edu.dto.PromotionSpaceDTO;
import com.learning.edu.resonse.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//name就是远程调用哪个服务
@FeignClient(name = "edu-ad-boot",path = "/ad")
public interface AdRemoteService {

    @GetMapping("/space/getAllSpaces")
    List<PromotionSpaceDTO> getAllSpaces();

    @GetMapping("/getAdBySpaceKey")
    List<PromotionSpaceDTO> getAdBySpaceKey(@RequestParam("spaceKey")String[] spaceKey);

    @PostMapping("/space/saveOrUpdateSpace")
    ResponseDTO saveOrUpdateSpace(@RequestBody PromotionSpaceDTO spaceDTO);

    @GetMapping("/space/getSpaceById")
    PromotionSpaceDTO getSpaceById(@RequestParam("id") Integer id);

    @GetMapping("/getAllAds")
    List<PromotionAdDTO> getAllAds();

    @PostMapping("/saveOrUpdateAd")
    ResponseDTO saveOrUpdateAd(@RequestBody PromotionAdDTO adDTO);

    @GetMapping("/getAdById")
    PromotionAdDTO getAdById(@RequestParam("id") Integer id);
}

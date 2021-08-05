package com.learning.edu.remote;

import com.learning.edu.dto.PromotionSpaceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//name就是远程调用哪个服务
@FeignClient(name = "edu-ad-boot",path = "/ad")
public interface AdRemoteService {

    @GetMapping("/space/getAllSpaces")
    List<PromotionSpaceDTO> getAllSpaces();

    @GetMapping("/getAdBySpaceKey")
    List<PromotionSpaceDTO> getAdBySpaceKey(@RequestParam("spaceKey")String[] spaceKey);
}

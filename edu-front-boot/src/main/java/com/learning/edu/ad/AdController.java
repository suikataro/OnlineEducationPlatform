package com.learning.edu.ad;

import com.learning.edu.dto.PromotionSpaceDTO;
import com.learning.edu.remote.AdRemoteService;
import com.learning.edu.resonse.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ad")
public class AdController {
    @Autowired
    private AdRemoteService adRemoteService;

    @RequestMapping("/getAdBySpaceKey")
    public ResponseDTO getAdBySpaceKey(@RequestParam("spaceKey") String[] spaceKey) throws Exception{
        List<PromotionSpaceDTO> dtoList = adRemoteService.getAdBySpaceKey(spaceKey);
        return ResponseDTO.success(dtoList);
    }
}

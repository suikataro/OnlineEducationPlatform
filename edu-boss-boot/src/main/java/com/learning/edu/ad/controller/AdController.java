package com.learning.edu.ad.controller;

import com.learning.edu.dto.PromotionSpaceDTO;
import com.learning.edu.remote.AdRemoteService;
import com.learning.edu.resonse.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

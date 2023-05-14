package org.osiris.backend.controller;

import java.util.List;

import org.osiris.backend.dto.InitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.osiris.backend.entity.VideoType;
import org.osiris.backend.service.CommonService;


@RestController
@RequestMapping("/api/common")
@CrossOrigin(origins = "*")
public class CommonController {

    private final CommonService commonService;

    @Autowired
    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }

    @GetMapping("/get_select_list")
    public List<VideoType> getSelectList() {
        return commonService.getSelectList();
    }

    @GetMapping("/hi")
    public String getHi() {
        return "Hi";
    }

//    @GetMapping("/init")
//    public InitDTO appInit() {
//        return new InitDTO("Hello Ash");
//    }

    @GetMapping("/init")
    public Boolean appInit() {
        return true;
    }
}

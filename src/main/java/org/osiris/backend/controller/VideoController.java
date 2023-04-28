package org.osiris.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.osiris.backend.entity.Video;
import org.osiris.backend.service.VideoService;


@RestController
@RequestMapping("/api/video")
@CrossOrigin(origins = "*")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

//    @GetMapping("/getSelectList")
//    public List<VideoType> getSelectList() {
//        return videoService.getSelectList();
//    }

    @GetMapping("/hi")
    public String getHi() {
        return "Hi";
    }

    @PostMapping("/add")
    public void add(@RequestBody Video video) {
        System.out.println(video);
//        this.videoService.add();
    }

}

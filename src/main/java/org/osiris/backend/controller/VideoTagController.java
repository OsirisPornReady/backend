package org.osiris.backend.controller;

import org.osiris.backend.dto.TagDTO;
import org.osiris.backend.service.VideoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.osiris.backend.entity.Video;
import org.osiris.backend.service.VideoService;
@RestController
@RequestMapping("/api/video_tag")
@CrossOrigin(origins = "*")
public class VideoTagController {

    private final VideoTagService videoTagService;

    @Autowired
    public VideoTagController(VideoTagService videoTagService) {
        this.videoTagService = videoTagService;
    }

//    @GetMapping("/getSelectList")
//    public List<VideoType> getSelectList() {
//        return videoService.getSelectList();
//    }

    @GetMapping("/hi")
    public String getHi() {
        return "Hi";
    }

    @PostMapping
    public void add(@RequestBody TagDTO tag) {
        System.out.println(tag);
    }

    @PutMapping
    public void update(@RequestBody TagDTO tag) {
        System.out.println(tag);
    }

    @DeleteMapping
    public void delete(@RequestBody TagDTO tag) {
        System.out.println(tag);
    }

    @GetMapping
    public void get(@RequestBody TagDTO tag) {
        System.out.println(tag);
    }

}

package org.osiris.backend.controller;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.TagDTO;
import org.osiris.backend.entity.VideoTag;
import org.osiris.backend.service.VideoTagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/video_tag")
@CrossOrigin(origins = "*")
public class VideoTagController {

    private final VideoTagService videoTagService;
    private final SimpleDateFormat sdf;

    @Autowired
    public VideoTagController(VideoTagService videoTagService) {
        this.videoTagService = videoTagService;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @PostMapping
    public void add(@RequestBody TagDTO tag) {
        VideoTag videoTag = new VideoTag();
        videoTag.setTag(tag.getTag());
        videoTag.setRefCount(0);
        videoTag.setUpdateTime(sdf.format(new Date()));
        videoTagService.save(videoTag);
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

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return videoTagService.getByPage(pi, ps);
    }

    @GetMapping("/getSelectAll")
    public List<VideoTag> getSelectAll() {
        return videoTagService.getSelectAll();
    }

}

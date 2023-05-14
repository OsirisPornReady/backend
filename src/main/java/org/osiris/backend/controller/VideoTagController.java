package org.osiris.backend.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.TagDTO;
import org.osiris.backend.entity.VideoTag;
import org.osiris.backend.service.VideoTagService;

import org.springframework.beans.BeanUtils;
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
        BeanUtils.copyProperties(tag, videoTag);
        videoTag.setRefCount(0);
        videoTag.setUpdateTime(sdf.format(new Date()));
        videoTagService.save(videoTag);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody TagDTO tag) {
        UpdateWrapper<VideoTag> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        VideoTag videoTag = new VideoTag();
        BeanUtils.copyProperties(tag, videoTag);
        videoTag.setRefCount(0);
        videoTag.setUpdateTime(sdf.format(new Date()));
        videoTagService.update(videoTag, updateWrapper);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        videoTagService.removeById(id);
    }

    @GetMapping("/{id}")
    public VideoTag get(@PathVariable Integer id) {
        return videoTagService.getById(id);
    }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return videoTagService.getByPage(pi, ps);
    }

    @GetMapping("/get_select_all")
    public List<VideoTag> getSelectAll() {
        return videoTagService.list();
    }

}

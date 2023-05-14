package org.osiris.backend.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.TagDTO;
import org.osiris.backend.entity.VideoTag;
import org.osiris.backend.entity.VideoType;
import org.osiris.backend.service.VideoTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/video_type")
@CrossOrigin(origins = "*")
public class VideoTypeController {

    private final VideoTypeService videoTypeService;
    private final SimpleDateFormat sdf;

    @Autowired
    public VideoTypeController(VideoTypeService videoTypeService) {
        this.videoTypeService = videoTypeService;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @PostMapping
    public void add(@RequestBody VideoType videoType) { videoTypeService.save(videoType); }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody VideoType videoType) {
        UpdateWrapper<VideoType> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        videoTypeService.update(videoType, updateWrapper);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        videoTypeService.removeById(id);
    }

    @GetMapping("/{id}")
    public VideoType get(@PathVariable Integer id) {
        return videoTypeService.getById(id);
    }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return videoTypeService.getByPage(pi, ps);
    }

    @GetMapping("/get_select_all")
    public List<VideoType> getSelectAll() {
        return videoTypeService.list();
    }

}

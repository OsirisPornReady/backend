package org.osiris.backend.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import org.osiris.backend.dto.QualityDTO;
import org.osiris.backend.entity.VideoQuality;
import org.osiris.backend.service.VideoQualityService;
import org.osiris.backend.utils.DateConvertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.osiris.backend.dto.STResDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/video_quality")
@CrossOrigin(origins = "*")
public class VideoQualityController {

    private final VideoQualityService videoQualityService;

    @Autowired
    public VideoQualityController(VideoQualityService videoQualityService) {
        this.videoQualityService = videoQualityService;
    }

    @PostMapping
    public void add(@RequestBody QualityDTO qualityDTO) {
        VideoQuality videoQuality = new VideoQuality();
        BeanUtils.copyProperties(qualityDTO, videoQuality, "videoCount", "updateTime");
        videoQuality.setVideoCount(0);
        videoQuality.setUpdateTime(DateConvertUtils.date2string(new Date()));
        videoQualityService.save(videoQuality);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody QualityDTO qualityDTO) {
        UpdateWrapper<VideoQuality> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        VideoQuality videoQuality = new VideoQuality();
        BeanUtils.copyProperties(qualityDTO, videoQuality, "videoCount", "updateTime");
        videoQuality.setVideoCount(0);
        videoQuality.setUpdateTime(DateConvertUtils.date2string(new Date()));
        videoQualityService.update(videoQuality, updateWrapper);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        videoQualityService.removeById(id);
    }

    @GetMapping("/{id}")
    public VideoQuality get(@PathVariable Integer id) {
        return videoQualityService.getById(id);
    }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return videoQualityService.getByPage(pi, ps);
    }

    @GetMapping("/get_select_all")
    public List<VideoQuality> getSelectAll() {
        return videoQualityService.list();
    }

    @GetMapping("/get_dict")
    public List<VideoQuality> getDict() {
//        return videoQualityService.getDict();
        return videoQualityService.list();
    }

}

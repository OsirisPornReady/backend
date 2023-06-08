package org.osiris.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.entity.Video;
import org.osiris.backend.service.VideoService;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/video")
@CrossOrigin(origins = "*")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public Integer add(@RequestBody VideoDTO videoDTO) {
        Date now = new Date();
        videoDTO.setAddTime(now);
        videoDTO.setUpdateTime(now);
        return videoService.addVideo(videoDTO);
    }

    @PutMapping("/{id}")
    public Integer update(@PathVariable Integer id, @RequestBody VideoDTO videoDTO) {
        videoDTO.setUpdateTime(new Date());
        return videoService.updateVideo(videoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { videoService.removeById(id); }

    @PostMapping("/bulk_delete")
    public void bulkDelete(@RequestBody List<Integer> ids) { videoService.removeByIds(ids); }

    @GetMapping("/{id}")
    public VideoDTO getById(@PathVariable Integer id) {
        return videoService.getDTOById(id);
    }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(
                @RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi,
                @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps,
                @RequestParam(value = "sort", required = false) List<String> sort,
                @RequestParam(value = "defaultSort", required = false) String defaultSort,
                @RequestParam(value = "keyword", required = false) String keyword,
                @RequestParam(value = "title", required = false) String title,
                @RequestParam(value = "serialNumber", required = false) String serialNumber,
                @RequestParam(value = "starsRaw", required = false) String starsRaw,
                @RequestParam(value = "tagsRaw", required = false) String tagsRaw,
                @RequestParam(value = "publishTimeStart", required = false) String publishTimeStart,
                @RequestParam(value = "publishTimeEnd", required = false) String publishTimeEnd,
                @RequestParam(value = "addTimeStart", required = false) String addTimeStart,
                @RequestParam(value = "addTimeEnd", required = false) String addTimeEnd
                            ) {
        return videoService.getByPage(pi, ps, sort, defaultSort, keyword, title, serialNumber, starsRaw, tagsRaw, publishTimeStart, publishTimeEnd, addTimeStart, addTimeEnd);
    }

    @GetMapping("/get_select_all")
    public List<Video> getSelectAll() {
        return videoService.list();
    }

    @GetMapping("/is_serial_number_exist/{serialNumber}")
    public Boolean isSerialNumberExist(@PathVariable String serialNumber) {
        return videoService.isSerialNumberExist(serialNumber);
    }

    @PostMapping("/is_title_exist")
    public Boolean isTitleExist(@RequestBody String title) {
        return videoService.isTitleExist(title);
    }

    @GetMapping("/switch_video_subscription/{id}")
    public void switchVideoSubscription(@PathVariable Integer id) {
        videoService.switchVideoSubscription(id);
    }
}

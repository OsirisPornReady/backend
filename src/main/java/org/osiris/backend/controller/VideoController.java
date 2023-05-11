package org.osiris.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.entity.Video;
import org.osiris.backend.service.VideoService;

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
    public void add(@RequestBody VideoDTO videoDTO) { videoService.addVideo(videoDTO); }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody VideoDTO videoDTO) { videoService.updateVideo(videoDTO, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { videoService.removeById(id); }

    @GetMapping("/{id}")
    public VideoDTO getById(@PathVariable Integer id) {
        return videoService.getDTOById(id);
    }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(
                @RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi,
                @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps,
                @RequestParam(value = "sort", required = false) String sort,
                @RequestParam(value = "keyword", required = false) String keyword,
                @RequestParam(value = "serialNumber", required = false) String serialNumber,
                @RequestParam(value = "publishTime", required = false) String publishTime
                            ) {
        return videoService.getByPage(pi, ps, sort, keyword, serialNumber, publishTime);
    }

    @GetMapping("/getSelectAll")
    public List<Video> getSelectAll() {
        return videoService.list();
    }

    @GetMapping("/isSerialNumberExist/{serialNumber}")
    public boolean isSerialNumberExist(@PathVariable String serialNumber) {
        return videoService.isSerialNumberExist(serialNumber);
    }

    @GetMapping("/switchVideoSubscription/{id}")
    public void switchVideoSubscription(@PathVariable Integer id) {
        videoService.switchVideoSubscription(id);
    }
}

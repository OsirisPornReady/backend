package org.osiris.backend.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoAlbumDTO;
import org.osiris.backend.entity.VideoAlbum;
import org.osiris.backend.entity.VideoType;
import org.osiris.backend.service.VideoAlbumService;
import org.osiris.backend.service.VideoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/video_album")
@CrossOrigin(origins = "*")
public class VideoAlbumController {

    private final VideoAlbumService videoAlbumService;

    @Autowired
    public VideoAlbumController(VideoAlbumService videoAlbumService) {
        this.videoAlbumService = videoAlbumService;
    }

    @PostMapping
    public void add(@RequestBody VideoAlbumDTO videoAlbumDTO) { videoAlbumService.addVideoAlbum(videoAlbumDTO); }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody VideoAlbumDTO videoAlbumDTO) {
        videoAlbumService.updateVideoAlbum(videoAlbumDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        videoAlbumService.removeById(id);
    }

    @GetMapping("/{id}")
    public VideoAlbumDTO getById(@PathVariable Integer id) { return videoAlbumService.getDTOById(id); }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return videoAlbumService.getByPage(pi, ps);
    }

    @GetMapping("/get_select_all")
    public List<VideoAlbum> getSelectAll() {
        return videoAlbumService.list();
    }

}

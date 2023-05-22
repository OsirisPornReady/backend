package org.osiris.backend.controller;

import org.osiris.backend.dto.ComicDTO;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.entity.Comic;
import org.osiris.backend.entity.Video;
import org.osiris.backend.service.ComicService;
import org.osiris.backend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/comic")
@CrossOrigin(origins = "*")
public class ComicController {

    private final ComicService comicService;

    @Autowired
    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    @PostMapping
    public void add(@RequestBody ComicDTO comicDTO) {
        Date now = new Date();
//        videoDTO.setAddTime(now);
//        videoDTO.setUpdateTime(now);
        comicService.addComic(comicDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody ComicDTO comicDTO) {
//        videoDTO.setUpdateTime(new Date());
        comicService.updateComic(comicDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { comicService.removeById(id); }

    @PostMapping("/bulk_delete")
    public void bulkDelete(@RequestBody List<Integer> ids) { comicService.removeByIds(ids); }

    @GetMapping("/{id}")
    public ComicDTO getById(@PathVariable Integer id) {
        return comicService.getDTOById(id);
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
        return comicService.getByPage(pi, ps, sort, defaultSort, keyword, title, serialNumber, starsRaw, tagsRaw, publishTimeStart, publishTimeEnd, addTimeStart, addTimeEnd);
    }

    @GetMapping("/get_select_all")
    public List<Comic> getSelectAll() {
        return comicService.list();
    }

//    @GetMapping("/is_serial_number_exist/{serialNumber}")
//    public Boolean isSerialNumberExist(@PathVariable String serialNumber) {
//        return videoService.isSerialNumberExist(serialNumber);
//    }
//
//    @PostMapping("/is_title_exist")
//    public Boolean isTitleExist(@RequestBody String title) {
//        return videoService.isTitleExist(title);
//    }
//
//    @GetMapping("/switch_video_subscription/{id}")
//    public void switchVideoSubscription(@PathVariable Integer id) {
//        videoService.switchVideoSubscription(id);
//    }
}

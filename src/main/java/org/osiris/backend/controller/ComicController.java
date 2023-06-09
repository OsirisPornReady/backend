package org.osiris.backend.controller;

import org.osiris.backend.dto.ComicDTO;
import org.osiris.backend.dto.LocalComicDTO;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Comic;
import org.osiris.backend.service.ComicService;
import org.osiris.backend.service.LocalComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/comic")
@CrossOrigin(origins = "*")
public class ComicController {

    private final ComicService comicService;
    private final LocalComicService localComicService;

    @Autowired
    public ComicController(ComicService comicService, LocalComicService localComicService) {
        this.comicService = comicService;
        this.localComicService = localComicService;
    }

    @PostMapping
    public void add(@RequestBody ComicDTO comicDTO) {
        Date now = new Date();
        comicDTO.setAddTime(now);
        comicDTO.setUpdateTime(now);
        comicService.addComic(comicDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody ComicDTO comicDTO) {
        comicDTO.setUpdateTime(new Date());
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
                @RequestParam(value = "titleJap", required = false) String titleJap,
                @RequestParam(value = "languageTags", required = false) String languageTags,
                @RequestParam(value = "parodyTags", required = false) String parodyTags,
                @RequestParam(value = "characterTags", required = false) String characterTags,
                @RequestParam(value = "groupTags", required = false) String groupTags,
                @RequestParam(value = "artistTags", required = false) String artistTags,
                @RequestParam(value = "maleTags", required = false) String maleTags,
                @RequestParam(value = "femaleTags", required = false) String femaleTags,
                @RequestParam(value = "mixedTags", required = false) String mixedTags,
                @RequestParam(value = "otherTags", required = false) String otherTags,
                @RequestParam(value = "postedTimeStart", required = false) String postedTimeStart,
                @RequestParam(value = "postedTimeEnd", required = false) String postedTimeEnd,
                @RequestParam(value = "addTimeStart", required = false) String addTimeStart,
                @RequestParam(value = "addTimeEnd", required = false) String addTimeEnd,
                @RequestParam(value = "compoundKeyword", required = false) List<String> compoundKeyword
                            ) {
        return comicService.getByPage(pi, ps, sort, defaultSort, keyword, title, titleJap, languageTags, parodyTags, characterTags, groupTags, artistTags, maleTags, femaleTags, mixedTags, otherTags, postedTimeStart, postedTimeEnd, addTimeStart, addTimeEnd, compoundKeyword);
    }

    @GetMapping("/get_select_all")
    public List<Comic> getSelectAll() {
        return comicService.list();
    }

//    @GetMapping("/is_serial_number_exist/{serialNumber}")
//    public Boolean isSerialNumberExist(@PathVariable String serialNumber) {
//        return videoService.isSerialNumberExist(serialNumber);
//    }

    @PostMapping("/is_title_exist")
    public Boolean isTitleExist(@RequestBody String title) {
        return comicService.isTitleExist(title);
    }

//    @GetMapping("/switch_video_subscription/{id}")
//    public void switchVideoSubscription(@PathVariable Integer id) {
//        videoService.switchVideoSubscription(id);
//    }


    @PostMapping("/upload_local_comic")
    public Boolean uploadLocalComic(@RequestPart MultipartFile file) {
        return true;
    }

    @PostMapping("/add_local_comic")
    public void addLocalComic(@RequestBody LocalComicDTO localComicDTO) {
        Date now = new Date();
        localComicDTO.setAddTime(now);
        localComicService.addLocalComic(localComicDTO);
    }

    @PutMapping("update_local_comic/{id}")
    public void updateLocalComic(@PathVariable Integer id, @RequestBody LocalComicDTO localComicDTO) { localComicService.updateLocalComic(localComicDTO, id); }

    @DeleteMapping("delete_local_comic/{id}")
    public void deleteLocalComic(@PathVariable Integer id) { localComicService.removeById(id); }

    @GetMapping("get_local_comic_by_id/{id}")
    public LocalComicDTO getLocalComicById(@PathVariable Integer id) { return localComicService.getDTOById(id); }

    @GetMapping("get_local_comic_list_by_comic_id/{comicId}")
    public List<LocalComicDTO> getLocalComicListByComicId(@PathVariable Integer comicId) { return localComicService.getListByComicId(comicId); }

    @GetMapping("get_comic_id_list_own_local")
    public List<Integer> getComicIdListOwnLocal() {
        return this.localComicService.getComicIdListOwnLocal();
    }
}

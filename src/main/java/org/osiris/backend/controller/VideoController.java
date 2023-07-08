package org.osiris.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.dto.LocalVideoDTO;
import org.osiris.backend.entity.Video;
import org.osiris.backend.entity.LocalVideo;

import org.osiris.backend.service.VideoService;
import org.osiris.backend.service.LocalVideoService;
import org.osiris.backend.service.VideoOnClientService;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/video")
@CrossOrigin(origins = "*")
public class VideoController {

    private final VideoService videoService;
    private final LocalVideoService localVideoService;
    private final VideoOnClientService videoOnClientService;

    @Autowired
    public VideoController(VideoService videoService, LocalVideoService localVideoService, VideoOnClientService videoOnClientService) {
        this.videoService = videoService;
        this.localVideoService = localVideoService;
        this.videoOnClientService = videoOnClientService;
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
                @RequestParam(value = "addTimeEnd", required = false) String addTimeEnd,
                @RequestParam(value = "compoundKeyword", required = false) List<String> compoundKeyword,
                @RequestParam(value = "onClient", required = false, defaultValue = "0") Integer onClient
                            ) {
        return videoService.getByPage(pi, ps, sort, defaultSort, keyword, title, serialNumber, starsRaw, tagsRaw, publishTimeStart, publishTimeEnd, addTimeStart, addTimeEnd, compoundKeyword, onClient);
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
    
    @PostMapping("/add_local_video")
    public void addLocalVideo(@RequestBody LocalVideoDTO localVideoDTO) {
        Date now = new Date();
        localVideoDTO.setAddTime(now);
        localVideoService.addLocalVideo(localVideoDTO);
    }

    @PutMapping("update_local_video/{id}")
    public void updateLocalVideo(@PathVariable Integer id, @RequestBody LocalVideoDTO localVideoDTO) { localVideoService.updateLocalVideo(localVideoDTO, id); }

    @DeleteMapping("delete_local_video/{id}")
    public void deleteLocalVideo(@PathVariable Integer id) { localVideoService.removeById(id); }

    @GetMapping("get_local_video_by_id/{id}")
    public LocalVideoDTO getLocalVideoById(@PathVariable Integer id) { return localVideoService.getDTOById(id); }

    @GetMapping("get_local_video_list_by_video_id/{videoId}")
    public List<LocalVideoDTO> getLocalVideoListByVideoId(@PathVariable Integer videoId) { return localVideoService.getListByVideoId(videoId); }

    @GetMapping("get_video_id_list_own_local")
    public List<Integer> getVideoIdListOwnLocal() {
        return this.localVideoService.getVideoIdListOwnLocal();
    }

    @GetMapping("check_video_onStorage_status/{videoId}")
    public void checkVideoOnStorageStatus(@PathVariable Integer videoId) {
        Boolean videoIdOwnLocalVideoStatus = localVideoService.isVideoIdOwnLocalVideo(videoId);
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setOnStorage(videoIdOwnLocalVideoStatus);
        videoService.updateVideo(videoDTO, videoId);
    }

    @GetMapping("get_video_id_list_on_client")
    public List<Integer> getVideoIdListOnClient() {
        return videoOnClientService.getVideoIdList();
    }

    @GetMapping("push_video_on_client/{videoId}")
    public void pushVideoOnClient(@PathVariable Integer videoId) {
        videoOnClientService.pushVideoOnClient(videoId);
    }

    @GetMapping("pull_video_off_client/{videoId}")
    public void pullVideoOffClient(@PathVariable Integer videoId) {
        videoOnClientService.pullVideoOffClient(videoId);
    }

    @GetMapping("swap_custom_sort_order")
    public void swapCustomSortOrder(
            @RequestParam(value = "idA") Integer idA,
            @RequestParam(value = "idB") Integer idB
    ) {
        videoService.swapCustomSortOrder(idA, idB);
    }

}

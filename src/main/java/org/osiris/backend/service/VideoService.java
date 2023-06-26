package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.entity.Video;

import java.util.List;


public interface VideoService extends IService<Video> {
    public Video dto2entity(VideoDTO videoDTO);
    public VideoDTO entity2dto(Video video);
    public STResDTO getByPage(Integer pi, Integer ps, List<String> sort, String defaultSort, String keyword, String title, String serialNumber, String starsRaw, String tagsRaw, String publishTimeStart, String publishTimeEnd, String addTimeStart, String addTimeEnd, List<String> compoundKeyword);
    public Integer addVideo(VideoDTO videoDTO);
    public Integer updateVideo(VideoDTO videoDTO, Integer id);
    public VideoDTO getDTOById(Integer id);
    public Boolean isSerialNumberExist(String serialNumber);
    public Boolean isTitleExist(String title);
    public void switchVideoSubscription(Integer id);
}

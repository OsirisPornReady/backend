package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.entity.Video;


public interface VideoService extends IService<Video> {
    public Video dto2entity(VideoDTO videoDTO);
    public VideoDTO entity2dto(Video video);
    public STResDTO getByPage(Integer pi, Integer ps);
    public void addVideo(VideoDTO videoDTO);
    public void updateVideo(VideoDTO videoDTO, Integer id);
    public VideoDTO getDTOById(Integer id);
}

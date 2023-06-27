package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.LocalVideoDTO;
import org.osiris.backend.entity.LocalVideo;

import java.util.List;


public interface LocalVideoService extends IService<LocalVideo> {
    public LocalVideo dto2entity(LocalVideoDTO localVideoDTO);
    public LocalVideoDTO entity2dto(LocalVideo localVideo);
    public List<LocalVideoDTO> getListByVideoId(Integer VideoId);
    public void addLocalVideo(LocalVideoDTO localVideoDTO);
    public void updateLocalVideo(LocalVideoDTO localVideoDTO, Integer id);
    public LocalVideoDTO getDTOById(Integer id);
    public List<Integer> getVideoIdListOwnLocal();
}

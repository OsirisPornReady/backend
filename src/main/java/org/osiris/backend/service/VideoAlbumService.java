package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoAlbumDTO;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.entity.Video;
import org.osiris.backend.entity.VideoAlbum;


public interface VideoAlbumService extends IService<VideoAlbum> {
    public VideoAlbum dto2entity(VideoAlbumDTO videoAlbumDTO);
    public VideoAlbumDTO entity2dto(VideoAlbum videoAlbum);
    public STResDTO getByPage(Integer pi, Integer ps);
    public void addVideoAlbum(VideoAlbumDTO videoAlbumDTO);
    public void updateVideoAlbum(VideoAlbumDTO videoAlbumDTO, Integer id);
    public VideoAlbumDTO getDTOById(Integer id);
}

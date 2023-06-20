package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;

import org.osiris.backend.entity.ComicAlbum;
import org.osiris.backend.dto.ComicAlbumDTO;
import org.osiris.backend.dto.STResDTO;

import java.util.List;


public interface ComicAlbumService extends IService<ComicAlbum> {
    public ComicAlbum dto2entity(ComicAlbumDTO comicAlbumDTO);
    public ComicAlbumDTO entity2dto(ComicAlbum comicAlbum);
    public STResDTO getByPage(Integer pi, Integer ps);
    public void addComicAlbum(ComicAlbumDTO comicAlbumDTO);
    public void updateComicAlbum(ComicAlbumDTO comicAlbumDTO, Integer id);
    public ComicAlbumDTO getDTOById(Integer id);
//    public void collectVideo(Integer id, VideoCollectDTO videoCollectDTO);
//    public List<VideoAlbum> getAlbumCollectedVideo(Integer id);
}

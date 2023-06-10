package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.LocalComic;
import org.osiris.backend.dto.LocalComicDTO;

import java.util.List;


public interface LocalComicService extends IService<LocalComic> {
    public LocalComic dto2entity(LocalComicDTO localComicDTO);
    public LocalComicDTO entity2dto(LocalComic localComic);
    public List<LocalComicDTO> getListByComicId(Integer comicId);
    public void addLocalComic(LocalComicDTO localComicDTO);
    public void updateLocalComic(LocalComicDTO localComicDTO, Integer id);
    public LocalComicDTO getDTOById(Integer id);
}

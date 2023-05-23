package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.ComicDTO;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.entity.Comic;

import java.util.List;


public interface ComicService extends IService<Comic> {
    public Comic dto2entity(ComicDTO comicDTO);
    public ComicDTO entity2dto(Comic comic);
    public STResDTO getByPage(Integer pi, Integer ps, List<String> sort, String defaultSort, String keyword, String title, String titleJap, String languageTags, String parodyTags, String characterTags, String groupTags, String artistTags, String maleTags, String femaleTags, String mixedTags, String otherTags, String postedTimeStart, String postedTimeEnd, String addTimeStart, String addTimeEnd);
    public void addComic(ComicDTO comicDTO);
    public void updateComic(ComicDTO comicDTO, Integer id);
    public ComicDTO getDTOById(Integer id);
//    public Boolean isSerialNumberExist(String serialNumber);
    public Boolean isTitleExist(String title);
//    public void switchVideoSubscription(Integer id);
}

package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.osiris.backend.dto.ComicDTO;
import org.osiris.backend.dto.LocalComicDTO;
import org.osiris.backend.entity.Comic;
import org.osiris.backend.entity.LocalComic;
import org.osiris.backend.mapper.LocalComicMapper;
import org.osiris.backend.service.LocalComicService;

import org.osiris.backend.utils.ArrayConvertUtils;
import org.osiris.backend.utils.DateConvertUtils;
import org.osiris.backend.utils.StringManipUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class LocalComicServiceImpl extends ServiceImpl<LocalComicMapper, LocalComic> implements LocalComicService {

    @Override
    public LocalComic dto2entity(LocalComicDTO localComicDTO) {
        LocalComic localComic = new LocalComic();
        BeanUtils.copyProperties(localComicDTO, localComic, "addTime", "localComicPicSrcList");

        String localComicPicSrcList = ArrayConvertUtils.liststring2string(localComicDTO.getLocalComicPicSrcList());
        String addTime = DateConvertUtils.date2string(localComicDTO.getAddTime());

        localComic.setLocalComicPicSrcList(localComicPicSrcList);
        localComic.setAddTime(addTime);

        return localComic;
    }

    @Override
    public LocalComicDTO entity2dto(LocalComic localComic) {
        LocalComicDTO localComicDTO = new LocalComicDTO();
        BeanUtils.copyProperties(localComic, localComicDTO, "addTime", "localComicPicSrcList");

        List<String> localComicPicSrcList = ArrayConvertUtils.string2stringlist(localComic.getLocalComicPicSrcList());
        Date addTime = DateConvertUtils.string2date(localComic.getAddTime());

        localComicDTO.setLocalComicPicSrcList(localComicPicSrcList);
        localComicDTO.setAddTime(addTime);

        return localComicDTO;
    }

    @Override
    public List<LocalComicDTO> getListByComicId(Integer comicId) {
        QueryWrapper<LocalComic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comicId", comicId);
        List<LocalComic> list = this.list(queryWrapper);
        return list.stream().map(this::entity2dto).toList();
    }

    @Override
    public void addLocalComic(LocalComicDTO localComicDTO) {
        this.save(this.dto2entity(localComicDTO));
    }

    @Override
    public void updateLocalComic(LocalComicDTO localComicDTO, Integer id) {
        UpdateWrapper<LocalComic> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        this.update(this.dto2entity(localComicDTO), updateWrapper);
    }

    @Override
    public LocalComicDTO getDTOById(Integer id) {
        return entity2dto(this.getById(id));
    }

}

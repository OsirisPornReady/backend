package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.osiris.backend.dto.LocalVideoDTO;
import org.osiris.backend.entity.LocalVideo;
import org.osiris.backend.mapper.LocalVideoMapper;
import org.osiris.backend.service.LocalVideoService;
import org.osiris.backend.utils.ArrayConvertUtils;
import org.osiris.backend.utils.DateConvertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class LocalVideoServiceImpl extends ServiceImpl<LocalVideoMapper, LocalVideo> implements LocalVideoService {

    @Override
    public LocalVideo dto2entity(LocalVideoDTO localVideoDTO) {
        LocalVideo localVideo = new LocalVideo();
        BeanUtils.copyProperties(localVideoDTO, localVideo, "addTime", "pathList");

        String pathList = ArrayConvertUtils.liststring2string(localVideoDTO.getPathList());
        String addTime = DateConvertUtils.date2string(localVideoDTO.getAddTime());

        localVideo.setPathList(pathList);
        localVideo.setAddTime(addTime);

        return localVideo;
    }

    @Override
    public LocalVideoDTO entity2dto(LocalVideo localVideo) {
        LocalVideoDTO localVideoDTO = new LocalVideoDTO();
        BeanUtils.copyProperties(localVideo, localVideoDTO, "addTime", "pathList");

        List<String> pathList = ArrayConvertUtils.string2stringlist(localVideo.getPathList());
        Date addTime = DateConvertUtils.string2date(localVideo.getAddTime());

        localVideoDTO.setPathList(pathList);
        localVideoDTO.setAddTime(addTime);

        return localVideoDTO;
    }

    @Override
    public List<LocalVideoDTO> getListByVideoId(Integer videoId) {
        QueryWrapper<LocalVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("videoId", videoId);
        List<LocalVideo> list = this.list(queryWrapper);
        return list.stream().map(this::entity2dto).toList();
    }

    @Override
    public void addLocalVideo(LocalVideoDTO localVideoDTO) {
        this.save(this.dto2entity(localVideoDTO));
    }

    @Override
    public void updateLocalVideo(LocalVideoDTO localVideoDTO, Integer id) {
        UpdateWrapper<LocalVideo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        this.update(this.dto2entity(localVideoDTO), updateWrapper);
    }

    @Override
    public LocalVideoDTO getDTOById(Integer id) {
        return entity2dto(this.getById(id));
    }

    @Override
    public List<Integer> getVideoIdListOwnLocal() {
        QueryWrapper<LocalVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "videoId");
        List<LocalVideo> list = this.list(queryWrapper);
        return list.stream().map(LocalVideo::getVideoId).distinct().toList();
    }

}

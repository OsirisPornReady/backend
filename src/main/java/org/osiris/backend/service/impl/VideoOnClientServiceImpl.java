package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import org.osiris.backend.entity.VideoOnClient;
import org.osiris.backend.mapper.VideoOnClientMapper;
import org.osiris.backend.service.VideoOnClientService;

import org.osiris.backend.utils.ArrayConvertUtils;
import org.osiris.backend.utils.DateConvertUtils;
import org.springframework.beans.BeanUtils;


import java.util.Date;
import java.util.List;


@Service
public class VideoOnClientServiceImpl extends ServiceImpl<VideoOnClientMapper, VideoOnClient> implements VideoOnClientService {

//    @Override
//    public LocalVideo dto2entity(LocalVideoDTO localVideoDTO) {
//        LocalVideo localVideo = new LocalVideo();
//        BeanUtils.copyProperties(localVideoDTO, localVideo, "addTime", "pathList");
//
//        String pathList = ArrayConvertUtils.liststring2string(localVideoDTO.getPathList());
//        String addTime = DateConvertUtils.date2string(localVideoDTO.getAddTime());
//
//        localVideo.setPathList(pathList);
//        localVideo.setAddTime(addTime);
//
//        return localVideo;
//    }
//
//    @Override
//    public LocalVideoDTO entity2dto(LocalVideo localVideo) {
//        LocalVideoDTO localVideoDTO = new LocalVideoDTO();
//        BeanUtils.copyProperties(localVideo, localVideoDTO, "addTime", "pathList");
//
//        List<String> pathList = ArrayConvertUtils.string2stringlist(localVideo.getPathList());
//        Date addTime = DateConvertUtils.string2date(localVideo.getAddTime());
//
//        localVideoDTO.setPathList(pathList);
//        localVideoDTO.setAddTime(addTime);
//
//        return localVideoDTO;
//    }



    @Override
    public List<Integer> getVideoIdList() {
        QueryWrapper<VideoOnClient> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "videoId");
        List<VideoOnClient> list = this.list(queryWrapper);
        return list.stream().map(VideoOnClient::getVideoId).distinct().toList();
    }

    @Override
    public void pushVideoOnClient(Integer videoId) {
        QueryWrapper<VideoOnClient> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "videoId");
        queryWrapper.eq("videoId", videoId);
        List<VideoOnClient> list = this.list(queryWrapper);
        if (list.size() == 0) {
            VideoOnClient videoOnClient = new VideoOnClient();
            videoOnClient.setVideoId(videoId);
            this.save(videoOnClient);
        }
    }

    @Override
    public void pullVideoOffClient(Integer videoId) {
        QueryWrapper<VideoOnClient> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("videoId", videoId);
        this.remove(queryWrapper);
    }

}

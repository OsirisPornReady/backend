package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.osiris.backend.utils.StringManipUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Video;
import org.osiris.backend.mapper.VideoMapper;
import org.osiris.backend.service.VideoService;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.utils.ArrayConvertUtils;
import org.osiris.backend.utils.DateConvertUtils;



@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Override
    public Video dto2entity(VideoDTO videoDTO) {
        Video video = new Video();

        BeanUtils.copyProperties(videoDTO, video, "publishTime", "series", "tags", "stars", "tagsRaw", "starsRaw", "addTime", "updateTime", "videoSrc", "previewImageSrcList", "localPreviewImageSrcList");

        String tags = ArrayConvertUtils.list2string(videoDTO.getTags());
        String stars = ArrayConvertUtils.list2string(videoDTO.getStars());
        String tagsRaw = ArrayConvertUtils.liststring2string(videoDTO.getTagsRaw());
        String starsRaw = ArrayConvertUtils.liststring2string(videoDTO.getStarsRaw());
        String series = ArrayConvertUtils.liststring2string(videoDTO.getSeries());
        String videoSrc = ArrayConvertUtils.liststring2string(videoDTO.getVideoSrc());
        String previewImageSrcList = ArrayConvertUtils.liststring2string(videoDTO.getPreviewImageSrcList());
        String localPreviewImageSrcList = ArrayConvertUtils.liststring2string(videoDTO.getLocalPreviewImageSrcList());
        String publishTime = DateConvertUtils.date2string(videoDTO.getPublishTime());
        String addTime = DateConvertUtils.date2string(videoDTO.getAddTime());
        String updateTime = DateConvertUtils.date2string(videoDTO.getUpdateTime());

        video.setTags(tags);
        video.setStars(stars);
        video.setTagsRaw(tagsRaw);
        video.setStarsRaw(starsRaw);
        video.setSeries(series);
        video.setVideoSrc(videoSrc);
        video.setPreviewImageSrcList(previewImageSrcList);
        video.setLocalPreviewImageSrcList(localPreviewImageSrcList);
        video.setPublishTime(publishTime);
        video.setAddTime(addTime);
        video.setUpdateTime(updateTime);
        return video;
    }

    @Override
    public VideoDTO entity2dto(Video video) {
        VideoDTO videoDTO = new VideoDTO();
        BeanUtils.copyProperties(video, videoDTO, "publishTime", "series", "tags", "stars", "tagsRaw", "starsRaw", "addTime", "updateTime", "videoSrc", "previewImageSrcList", "localPreviewImageSrcList");
        List<Integer> tags = ArrayConvertUtils.string2list(video.getTags());
        List<Integer> stars = ArrayConvertUtils.string2list(video.getStars());
        List<String> tagsRaw = ArrayConvertUtils.string2stringlist(video.getTagsRaw());
        List<String> starsRaw = ArrayConvertUtils.string2stringlist(video.getStarsRaw());
        List<String> series = ArrayConvertUtils.string2stringlist(video.getSeries());
        List<String> videoSrc = ArrayConvertUtils.string2stringlist(video.getVideoSrc());
        List<String> previewImageSrcList = ArrayConvertUtils.string2stringlist(video.getPreviewImageSrcList());
        List<String> localPreviewImageSrcList = ArrayConvertUtils.string2stringlist(video.getLocalPreviewImageSrcList());
        Date publishTime = DateConvertUtils.string2date(video.getPublishTime());
        Date addTime = DateConvertUtils.string2date(video.getAddTime());
        Date updateTime = DateConvertUtils.string2date(video.getUpdateTime());
        videoDTO.setTags(tags);
        videoDTO.setStars(stars);
        videoDTO.setTagsRaw(tagsRaw);
        videoDTO.setStarsRaw(starsRaw);
        videoDTO.setSeries(series);
        videoDTO.setVideoSrc(videoSrc);
        videoDTO.setPreviewImageSrcList(previewImageSrcList);
        videoDTO.setLocalPreviewImageSrcList(localPreviewImageSrcList);
        videoDTO.setPublishTime(publishTime);
        videoDTO.setAddTime(addTime);
        videoDTO.setUpdateTime(updateTime);
        return videoDTO;
    }

    @Override
    public STResDTO getByPage(Integer pi, Integer ps, List<String> sort, String defaultSort, String keyword, String serialNumber, String publishTime) {
        Page<Video> page = new Page<>(pi, ps);
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        if (sort != null) {
            sort.forEach(s -> {
                List<String> params = StringManipUtils.splitSort(s);
                if (params.size() == 2) {
                    if (Objects.equals(params.get(1), "descend")) {
                        queryWrapper.orderByDesc(params.get(0));
                    } else if (Objects.equals(params.get(1), "ascend")) {
                        queryWrapper.orderByAsc(params.get(0));
                    }
                }
            });
        }
        if (defaultSort != null) {
            List<String> params = StringManipUtils.splitSort(defaultSort);
            if (params.size() == 2) {
                if (Objects.equals(params.get(1), "descend")) {
                    queryWrapper.orderByDesc(params.get(0));
                } else if (Objects.equals(params.get(1), "ascend")) {
                    queryWrapper.orderByAsc(params.get(0));
                }
            }
        }
        if (keyword != null) {
            queryWrapper.like("title", keyword);
        }
        if (serialNumber != null) {
            queryWrapper.like("serialNumber", serialNumber);
        }
        if (publishTime != null) {
            queryWrapper.like("publishTime", publishTime);
        }
        IPage<Video> ipage = this.page(page, queryWrapper);
        ipage.convert(this::entity2dto); //如果逻辑复杂一点还可以写成lambda表达式
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

    @Override
    public void addVideo(VideoDTO videoDTO) {
        this.save(this.dto2entity(videoDTO));
    }

    @Override
    public void updateVideo(VideoDTO videoDTO, Integer id) {
        UpdateWrapper<Video> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        this.update(this.dto2entity(videoDTO), updateWrapper);
    }

    @Override
    public VideoDTO getDTOById(Integer id) {
        return entity2dto(this.getById(id));
    }

    @Override
    public Boolean isSerialNumberExist(String serialNumber) {
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Video::getSerialNumber, serialNumber);
        List<Video> list = this.list(queryWrapper);
        return list.size() > 0;
    }

    @Override
    public Boolean isTitleExist(String title) {
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Video::getTitle, title);
        List<Video> list = this.list(queryWrapper);
        return list.size() > 0;
    }

    @Override
    public void switchVideoSubscription(Integer id) {
        Video video = this.getById(id);
        if (video != null) {
            Boolean onSubscription = video.getOnSubscription();
            Boolean newValue;
            if (onSubscription == null || onSubscription == false) {
                newValue = false;
            } else {
                newValue = true;
            }
            UpdateWrapper<Video> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id)
                    .set("onSubscription", newValue);
            this.update(updateWrapper);
        }
    }
}

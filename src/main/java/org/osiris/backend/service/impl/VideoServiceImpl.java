package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

        BeanUtils.copyProperties(videoDTO, video, "publishTime", "tags", "stars");

        String tags = ArrayConvertUtils.list2string(videoDTO.getTags());
        String stars = ArrayConvertUtils.list2string(videoDTO.getStars());
        String publishTime = DateConvertUtils.date2string(videoDTO.getPublishTime());

        video.setTags(tags);
        video.setStars(stars);
        video.setPublishTime(publishTime);
        return video;
    }

    @Override
    public VideoDTO entity2dto(Video video) {
        VideoDTO videoDTO = new VideoDTO();
        BeanUtils.copyProperties(video, videoDTO, "publishTime", "tags", "stars");
        List<Integer> tags = ArrayConvertUtils.string2list(video.getTags());
        List<Integer> stars = ArrayConvertUtils.string2list(video.getStars());
        Date publishTime = DateConvertUtils.string2date(video.getPublishTime());
        videoDTO.setTags(tags);
        videoDTO.setStars(stars);
        videoDTO.setPublishTime(publishTime);
        return videoDTO;
    }

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<Video> page = new Page<>(pi, ps);
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
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

}

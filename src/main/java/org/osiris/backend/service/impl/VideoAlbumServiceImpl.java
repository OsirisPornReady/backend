package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoAlbumDTO;
import org.osiris.backend.entity.VideoAlbum;
import org.osiris.backend.mapper.VideoAlbumMapper;
import org.osiris.backend.service.VideoAlbumService;
import org.osiris.backend.utils.ArrayConvertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoAlbumServiceImpl extends ServiceImpl<VideoAlbumMapper, VideoAlbum> implements VideoAlbumService {

    @Override
    public VideoAlbum dto2entity(VideoAlbumDTO videoAlbumDTO) {
        VideoAlbum videoAlbum = new VideoAlbum();
        BeanUtils.copyProperties(videoAlbumDTO, videoAlbum, "albumVideoList");
        String albumVideoList = ArrayConvertUtils.list2string(videoAlbumDTO.getAlbumVideoList());
        videoAlbum.setAlbumVideoList(albumVideoList);
        return videoAlbum;
    }

    @Override
    public VideoAlbumDTO entity2dto(VideoAlbum videoAlbum) {
        VideoAlbumDTO videoAlbumDTO = new VideoAlbumDTO();
        BeanUtils.copyProperties(videoAlbum, videoAlbumDTO, "albumVideoList");
        List<Integer> albumVideoList = ArrayConvertUtils.string2list(videoAlbum.getAlbumVideoList());
        videoAlbumDTO.setAlbumVideoList(albumVideoList);
        return videoAlbumDTO;
    }

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<VideoAlbum> page = new Page<>(pi, ps);
        QueryWrapper<VideoAlbum> queryWrapper = new QueryWrapper<>();
        IPage<VideoAlbum> ipage = this.page(page, queryWrapper);
        ipage.convert(this::entity2dto);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

    @Override
    public void addVideoAlbum(VideoAlbumDTO videoAlbumDTO) {
        this.save(this.dto2entity(videoAlbumDTO));
    }

    @Override
    public void updateVideoAlbum(VideoAlbumDTO videoAlbumDTO, Integer id) {
        UpdateWrapper<VideoAlbum> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        this.update(this.dto2entity(videoAlbumDTO), updateWrapper);
    }

    @Override
    public VideoAlbumDTO getDTOById(Integer id) {
        return entity2dto(this.getById(id));
    }

}

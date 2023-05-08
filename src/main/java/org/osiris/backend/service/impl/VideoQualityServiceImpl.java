package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.VideoQuality;
import org.osiris.backend.mapper.VideoQualityMapper;
import org.osiris.backend.service.VideoQualityService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class VideoQualityServiceImpl extends ServiceImpl<VideoQualityMapper, VideoQuality> implements VideoQualityService {

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<VideoQuality> page = new Page<>(pi, ps);
        QueryWrapper<VideoQuality> queryWrapper = new QueryWrapper<>();
        IPage<VideoQuality> ipage = this.page(page, queryWrapper);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

    @Override
    public Map<Integer, VideoQuality> getDict() {
        List<VideoQuality> list = this.list();
        return list.stream().collect(Collectors.toMap(VideoQuality::getId, VideoQuality -> VideoQuality));
    }

}

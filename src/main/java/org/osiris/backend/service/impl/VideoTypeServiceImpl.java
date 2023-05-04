package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.VideoType;
import org.osiris.backend.mapper.VideoTypeMapper;
import org.osiris.backend.service.VideoTypeService;

import java.util.List;


@Service
public class VideoTypeServiceImpl extends ServiceImpl<VideoTypeMapper, VideoType> implements VideoTypeService {

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<VideoType> page = new Page<>(pi, ps);
        QueryWrapper<VideoType> queryWrapper = new QueryWrapper<>();
        IPage<VideoType> ipage = this.page(page, queryWrapper);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

}

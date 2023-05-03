package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.TagDTO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.osiris.backend.entity.VideoTag;
import org.osiris.backend.mapper.VideoTagMapper;
import org.osiris.backend.service.VideoTagService;

import java.util.List;


@Service
public class VideoTagServiceImpl extends ServiceImpl<VideoTagMapper, VideoTag> implements VideoTagService {

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<VideoTag> page = new Page<>(pi, ps);
        QueryWrapper<VideoTag> queryWrapper = new QueryWrapper<>();
        IPage<VideoTag> ipage = this.page(page, queryWrapper);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

    @Override
    public List<VideoTag> getSelectAll() {
        return this.list();
    }
}

package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Area;
import org.osiris.backend.mapper.AreaMapper;
import org.osiris.backend.service.AreaService;
import org.springframework.stereotype.Service;


@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<Area> page = new Page<>(pi, ps);
        QueryWrapper<Area> queryWrapper = new QueryWrapper<>();
        IPage<Area> ipage = this.page(page, queryWrapper);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

}

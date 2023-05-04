package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.osiris.backend.dto.ActressDTO;
import org.osiris.backend.service.AreaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Actress;
import org.osiris.backend.mapper.ActressMapper;
import org.osiris.backend.service.CastService;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CastServiceImpl extends ServiceImpl<ActressMapper, Actress> implements CastService {

    private final AreaService areaService;

    @Autowired
    public CastServiceImpl(AreaService areaService) {
        this.areaService = areaService;
    }

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<Actress> page = new Page<>(pi, ps);
        QueryWrapper<Actress> queryWrapper = new QueryWrapper<>();
        IPage<Actress> ipage = this.page(page, queryWrapper);
        ipage.convert(u -> {
            ActressDTO v = new ActressDTO();
            BeanUtils.copyProperties(u, v, "area");
            List<Integer> area = Arrays.stream(u.getArea().split(",")).map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
            v.setArea(area);
            v.setAreaInfo(areaService.listByIds(area));
            return v;
        });
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

}

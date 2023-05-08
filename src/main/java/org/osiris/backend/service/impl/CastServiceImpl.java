package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.StarDTO;
import org.osiris.backend.entity.Star;
import org.osiris.backend.mapper.StarMapper;
import org.osiris.backend.service.AreaService;
import org.osiris.backend.utils.ArrayConvertUtils;
import org.osiris.backend.utils.DateConvertUtils;
import org.osiris.backend.service.CastService;

import java.util.List;


@Service
public class CastServiceImpl extends ServiceImpl<StarMapper, Star> implements CastService {

    private final AreaService areaService;

    @Autowired
    public CastServiceImpl(AreaService areaService) {
        this.areaService = areaService;
    }

    @Override
    public Star dto2entity(StarDTO starDTO) {
        Star star = new Star();
        BeanUtils.copyProperties(starDTO, star, "area");
        String area = ArrayConvertUtils.list2string(starDTO.getArea());
        star.setArea(area);
        return star;
    }

    @Override
    public StarDTO entity2dto(Star star) {
        StarDTO starDTO = new StarDTO();
        BeanUtils.copyProperties(star, starDTO, "area");
        List<Integer> area = ArrayConvertUtils.string2list(star.getArea());
        starDTO.setArea(area);
        starDTO.setAreaInfo(areaService.listByIds(area));
        return starDTO;
    }

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<Star> page = new Page<>(pi, ps);
        QueryWrapper<Star> queryWrapper = new QueryWrapper<>();
        IPage<Star> ipage = this.page(page, queryWrapper);
        ipage.convert(this::entity2dto);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

    @Override
    public void addStar(StarDTO starDTO) {
        this.save(this.dto2entity(starDTO));
    }

    @Override
    public void updateStar(StarDTO starDTO, Integer id) {
        UpdateWrapper<Star> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        this.update(this.dto2entity(starDTO), updateWrapper);
    }

    @Override
    public StarDTO getDTOById(Integer id) {
        return entity2dto(this.getById(id));
    }

}

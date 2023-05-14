package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.CrawlType;
import org.osiris.backend.mapper.CrawlTypeMapper;
import org.osiris.backend.service.CrawlTypeService;
import org.springframework.stereotype.Service;


@Service
public class CrawlTypeServiceImpl extends ServiceImpl<CrawlTypeMapper, CrawlType> implements CrawlTypeService {

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<CrawlType> page = new Page<>(pi, ps);
        QueryWrapper<CrawlType> queryWrapper = new QueryWrapper<>();
        IPage<CrawlType> ipage = this.page(page, queryWrapper);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

}

package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.OsirisSystemSetting;
import org.osiris.backend.mapper.OsirisSystemSettingMapper;
import org.osiris.backend.service.OsirisSystemSettingService;
import org.springframework.stereotype.Service;


@Service
public class OsirisSystemSettingServiceImpl extends ServiceImpl<OsirisSystemSettingMapper, OsirisSystemSetting> implements OsirisSystemSettingService {

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<OsirisSystemSetting> page = new Page<>(pi, ps);
        QueryWrapper<OsirisSystemSetting> queryWrapper = new QueryWrapper<>();
        IPage<OsirisSystemSetting> ipage = this.page(page, queryWrapper);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

}

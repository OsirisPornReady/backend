package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.OsirisSystemSetting;


public interface OsirisSystemSettingService extends IService<OsirisSystemSetting> {
    public STResDTO getByPage(Integer pi, Integer ps);
}

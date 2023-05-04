package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Area;


public interface AreaService extends IService<Area> {
    public STResDTO getByPage(Integer pi, Integer ps);
}

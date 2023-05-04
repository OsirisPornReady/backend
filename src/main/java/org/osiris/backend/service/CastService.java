package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Actress;


public interface CastService extends IService<Actress> {
    public STResDTO getByPage(Integer pi, Integer ps);
}

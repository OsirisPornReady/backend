package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.CrawlType;


public interface CrawlTypeService extends IService<CrawlType> {
    public STResDTO getByPage(Integer pi, Integer ps);
}

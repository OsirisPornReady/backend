package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.VideoType;


public interface VideoTypeService extends IService<VideoType> {
    public STResDTO getByPage(Integer pi, Integer ps);
}

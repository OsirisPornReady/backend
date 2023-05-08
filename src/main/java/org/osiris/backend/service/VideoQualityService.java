package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.VideoQuality;

import java.util.List;
import java.util.Map;


public interface VideoQualityService extends IService<VideoQuality> {
    public STResDTO getByPage(Integer pi, Integer ps);
    public Map<Integer, VideoQuality> getDict();
}

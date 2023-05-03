package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.TagDTO;
import org.osiris.backend.entity.Video;
import org.osiris.backend.entity.VideoTag;

import java.util.List;


public interface VideoTagService extends IService<VideoTag> {
    public STResDTO getByPage(Integer pi, Integer ps);

    public List<VideoTag> getSelectAll();
}

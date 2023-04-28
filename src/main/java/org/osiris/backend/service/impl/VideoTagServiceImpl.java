package org.osiris.backend.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.osiris.backend.entity.VideoTag;
import org.osiris.backend.mapper.VideoTagMapper;
import org.osiris.backend.service.VideoTagService;


@Service
public class VideoTagServiceImpl extends ServiceImpl<VideoTagMapper, VideoTag> implements VideoTagService {
}

package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.VideoOnClient;

import java.util.List;


public interface VideoOnClientService extends IService<VideoOnClient> {
    public List<Integer> getVideoIdList();

    public void pushVideoOnClient(Integer videoId);

    public void pullVideoOffClient(Integer videoId);
}

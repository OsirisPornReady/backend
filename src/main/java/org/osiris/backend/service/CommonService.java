package org.osiris.backend.service;

import org.osiris.backend.entity.VideoType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonService {

    @Autowired
    public List<VideoType> getSelectList() {

        List<VideoType> list = new ArrayList<>();
        return list;
    }

}

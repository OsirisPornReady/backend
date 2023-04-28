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

//        list.add(new VideoType("Japanese", "1"));
//        list.add(new VideoType("Westworld", "2"));
//        list.add(new VideoType("Chinese", "3"));

        return list;
    }

}

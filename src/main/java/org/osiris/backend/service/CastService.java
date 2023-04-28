package org.osiris.backend.service;

import org.osiris.backend.entity.Actress;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CastService {

    public String getHi() {
        return "Hi";
    }

    public List<Actress> getSelectList() {

        List<Actress> list = new ArrayList<>();

        return list;
    }
}

package org.osiris.backend.controller;

import java.util.List;

import org.osiris.backend.entity.Actress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.osiris.backend.service.CastService;


@RestController
@RequestMapping("/api/cast")
@CrossOrigin(origins = "*")
public class CastController {

    private final CastService castService;

    @Autowired
    public CastController(CastService castService) {
        this.castService = castService;
    }

    @GetMapping("/getSelectList")
    public List<Actress> getSelectList() {
        return castService.getSelectList();
    }

    @GetMapping("/hi")
    public String getHi() {
        return "Hi";
    }
}

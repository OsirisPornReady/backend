package org.osiris.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.osiris.backend.dto.StarDTO;
import org.osiris.backend.entity.Star;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.service.CastService;

import java.util.List;


@RestController
@RequestMapping("/api/cast")
@CrossOrigin(origins = "*")
public class CastController {

    private final CastService castService;

    @Autowired
    public CastController(CastService castService) {
        this.castService = castService;
    }

    @PostMapping
    public void add(@RequestBody StarDTO starDTO) { castService.addStar(starDTO); }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody StarDTO starDTO) { castService.updateStar(starDTO, id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        castService.removeById(id);
    }

    @GetMapping("/{id}")
    public StarDTO getById(@PathVariable Integer id) { return castService.getDTOById(id); }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return castService.getByPage(pi, ps);
    }

    @GetMapping("/getSelectAll")
    public List<Star> getSelectAll() {
        return castService.list();
    }

}

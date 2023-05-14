package org.osiris.backend.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Area;
import org.osiris.backend.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/area")
@CrossOrigin(origins = "*")
public class AreaController {

    private final AreaService areaService;
    private final SimpleDateFormat sdf;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @PostMapping
    public void add(@RequestBody Area videoArea) {
        areaService.save(videoArea);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Area videoArea) {
        UpdateWrapper<Area> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        areaService.update(videoArea, updateWrapper);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        areaService.removeById(id);
    }

    @GetMapping("/{id}")
    public Area get(@PathVariable Integer id) {
        return areaService.getById(id);
    }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return areaService.getByPage(pi, ps);
    }

    @GetMapping("/get_select_all")
    public List<Area> getSelectAll() {
        return areaService.list();
    }

}

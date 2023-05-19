package org.osiris.backend.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.OsirisSystemSetting;
import org.osiris.backend.service.OsirisSystemSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/osiris_system_setting")
@CrossOrigin(origins = "*")
public class OsirisSystemSettingController {

    private final OsirisSystemSettingService osirisSystemSettingService;

    @Autowired
    public OsirisSystemSettingController(OsirisSystemSettingService osirisSystemSettingService) {
        this.osirisSystemSettingService = osirisSystemSettingService;
    }

    @PostMapping
    public void add(@RequestBody OsirisSystemSetting osirisSystemSetting) {
        osirisSystemSettingService.save(osirisSystemSetting);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody OsirisSystemSetting osirisSystemSetting) {
        UpdateWrapper<OsirisSystemSetting> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        osirisSystemSettingService.update(osirisSystemSetting, updateWrapper);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        osirisSystemSettingService.removeById(id);
    }

    @GetMapping("/{id}")
    public OsirisSystemSetting get(@PathVariable Integer id) {
        return osirisSystemSettingService.getById(id);
    }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return osirisSystemSettingService.getByPage(pi, ps);
    }

    @GetMapping("/get_select_all")
    public List<OsirisSystemSetting> getSelectAll() {
        return osirisSystemSettingService.list();
    }

    @GetMapping("/get_setting_table")
    public List<OsirisSystemSetting> getSettingTable() {
        return osirisSystemSettingService.list();
    }

}

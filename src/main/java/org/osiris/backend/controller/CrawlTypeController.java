package org.osiris.backend.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Area;
import org.osiris.backend.entity.CrawlType;
import org.osiris.backend.service.AreaService;
import org.osiris.backend.service.CrawlTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/crawl_type")
@CrossOrigin(origins = "*")
public class CrawlTypeController {

    private final CrawlTypeService crawlTypeService;

    @Autowired
    public CrawlTypeController(CrawlTypeService crawlTypeService) {
        this.crawlTypeService = crawlTypeService;
    }

    @PostMapping
    public void add(@RequestBody CrawlType crawlType) { crawlTypeService.save(crawlType); }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody CrawlType crawlType) {
        UpdateWrapper<CrawlType> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        crawlTypeService.update(crawlType, updateWrapper);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        crawlTypeService.removeById(id);
    }

    @GetMapping("/{id}")
    public CrawlType get(@PathVariable Integer id) {
        return crawlTypeService.getById(id);
    }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return crawlTypeService.getByPage(pi, ps);
    }

    @GetMapping("/get_select_all")
    public List<CrawlType> getSelectAll() {
        return crawlTypeService.list();
    }

}

package org.osiris.backend.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.osiris.backend.dto.ActressDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Actress;
import org.osiris.backend.service.CastService;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cast")
@CrossOrigin(origins = "*")
public class CastController {

    private final CastService castService;
    private final SimpleDateFormat sdf;

    @Autowired
    public CastController(CastService castService) {
        this.castService = castService;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @PostMapping
    public void add(@RequestBody ActressDTO actressDTO) {
        Actress actress = new Actress();
        BeanUtils.copyProperties(actressDTO, actress, "area");
        String area = StringUtils.trimTrailingCharacter(StringUtils.trimLeadingCharacter(actressDTO.getArea().toString(), '['), ']');
        actress.setArea(area);
        castService.save(actress);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody ActressDTO actressDTO) {
        Actress actress = new Actress();
        BeanUtils.copyProperties(actressDTO, actress, "area");
        String area = StringUtils.trimTrailingCharacter(StringUtils.trimLeadingCharacter(actressDTO.getArea().toString(), '['), ']');
        actress.setArea(area);
        UpdateWrapper<Actress> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        castService.update(actress, updateWrapper);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        castService.removeById(id);
    }

    @GetMapping("/{id}")
    public ActressDTO get(@PathVariable Integer id) {
        Actress actress = castService.getById(id);
        ActressDTO actressDTO = new ActressDTO();
        BeanUtils.copyProperties(actress, actressDTO);
        List<Integer> area = Arrays.stream(actress.getArea().split(",")).map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
        actressDTO.setArea(area);
        return actressDTO;
    }

    @GetMapping("/get_by_page")
    public STResDTO getByPage(@RequestParam(value = "pi", required = false, defaultValue = "1") Integer pi, @RequestParam(value = "ps", required = false, defaultValue = "10") Integer ps) {
        return castService.getByPage(pi, ps);
    }

    @GetMapping("/getSelectAll")
    public List<Actress> getSelectAll() {
        return castService.list();
    }

}

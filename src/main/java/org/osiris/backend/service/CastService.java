package org.osiris.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.StarDTO;
import org.osiris.backend.entity.Star;


public interface CastService extends IService<Star> {
    public Star dto2entity(StarDTO starDTO);
    public StarDTO entity2dto(Star star);
    public STResDTO getByPage(Integer pi, Integer ps);
    public void addStar(StarDTO starDTO);
    public void updateStar(StarDTO starDTO, Integer id);
    public StarDTO getDTOById(Integer id);
}

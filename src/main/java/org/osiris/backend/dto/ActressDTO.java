package org.osiris.backend.dto;

import lombok.Data;
import org.osiris.backend.entity.Area;

import java.util.List;

@Data
public class ActressDTO {
    private Integer id;
    private String name;
    private List<Integer> area;
    private List<Area> areaInfo;
}

package org.osiris.backend.dto;

import lombok.Data;
import org.osiris.backend.entity.Area;

import java.util.List;

@Data
public class StarDTO {
    private Integer id;
    private String name;
    private String gender;
    private List<Integer> area;
    private List<Area> areaInfo;
}

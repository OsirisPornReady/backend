package org.osiris.backend.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class LocalVideoDTO {
    private Integer id;
    private Integer videoId;
    private List<String> pathList;
    private Date addTime;
    private String title;
    private String remark;
}

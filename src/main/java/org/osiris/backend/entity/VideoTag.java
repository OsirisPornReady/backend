package org.osiris.backend.entity;

import lombok.Data;

import java.util.Date;

@Data
public class VideoTag {
    private Integer id;
    private String tag;
    private Integer refCount;
    private Date updateTime;
}

package org.osiris.backend.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class LocalComicDTO {
    private Integer id;
    private Integer comicId;
    private List<String> localComicPicSrcList;
    private String comicPhysicalPath;
    private String comicServerPath;
    private String comicPhysicalDirectoryName;
    private String comicServerDirectoryName;
    private Date addTime;
    private String title;
    private String remark;
}

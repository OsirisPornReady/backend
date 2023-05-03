package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("Video")
@Data
public class Video {
    private Integer id;
    private String title;
    private String serialNumber;
    private int videoType;
    private int area;
    private Date publishTime;
    private Date addTime;
    private String description ;
}

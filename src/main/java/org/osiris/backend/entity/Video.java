package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

@TableName("Video")
@Data
public class Video {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    @TableField("onStorage")
    private boolean onStorage;
    @TableField("existSerialNumber")
    private boolean existSerialNumber;
    @TableField("serialNumber")
    private String serialNumber;
    @TableField("videoType")
    private Integer videoType;
    @TableField("videoResolution")
    private Integer videoResolution;
    @TableField("publishTime")
    private String publishTime;
    private Integer duration;
    private String director;
    private String producer;
    private String releaser;
    private String brand;
    @TableField("inSeries")
    private boolean inSeries;
    private String series;
    private String tags;
    private String stars;
    private String description;
}

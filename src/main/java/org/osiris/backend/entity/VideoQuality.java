package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("VideoQuality")
public class VideoQuality {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String quality;
    private String color;
    @TableField("videoCount")
    private Integer videoCount;
    @TableField("updateTime")
    private String updateTime;
}

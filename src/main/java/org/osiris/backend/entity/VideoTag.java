package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("VideoTag")
@Data
public class VideoTag {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String tag;
    @TableField("refCount")
    private Integer refCount;
    @TableField("updateTime")
    private String updateTime;
}

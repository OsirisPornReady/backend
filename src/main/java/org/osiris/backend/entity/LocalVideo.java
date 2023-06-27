package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("LocalVideo")
@Data
public class LocalVideo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("videoId")
    private Integer videoId;
    @TableField("pathList")
    private String pathList;
    @TableField("addTime")
    private String addTime;
    @TableField("title")
    private String title;
    @TableField("remark")
    private String remark;
}

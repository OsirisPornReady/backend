package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("CrawlType")
public class CrawlType {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    @TableField("crawlTypeKey")
    private Integer crawlTypeKey;
    @TableField("isActive")
    private Boolean isActive;  //boolean似乎会把字段名改成active
    @TableField("crawlApiUrl")
    private String crawlApiUrl;
}

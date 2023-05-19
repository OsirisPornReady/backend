package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("OsirisSystemSetting")
public class OsirisSystemSetting {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("settingKey")
    private String settingKey;
    @TableField("settingName")
    private String settingName;
    @TableField("settingType")
    private Integer settingType;
    @TableField("settingStringValue")
    private String settingStringValue;
    @TableField("settingIntegerValue")
    private Integer settingIntegerValue;
    @TableField("settingBooleanValue")
    private Boolean settingBooleanValue;
}

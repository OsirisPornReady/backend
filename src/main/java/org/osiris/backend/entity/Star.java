package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Star")
public class Star {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String gender;
    private String area;
}

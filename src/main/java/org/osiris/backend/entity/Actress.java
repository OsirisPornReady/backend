package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("Actress")
public class Actress {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String area;
}

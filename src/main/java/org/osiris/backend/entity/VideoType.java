package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("VideoType")
public class VideoType {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String type;
}

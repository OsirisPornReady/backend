package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("VideoAlbum")
public class VideoAlbum {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("albumName")
    private String albumName;
    @TableField("videoList")
    private String videoList;
}

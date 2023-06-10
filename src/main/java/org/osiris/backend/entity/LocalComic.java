package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("LocalComic")
@Data
public class LocalComic {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("comicId")
    private Integer comicId;
    @TableField("localComicPicSrcList")
    private String localComicPicSrcList;
    @TableField("comicPhysicalPath")
    private String comicPhysicalPath;
    @TableField("comicServerPath")
    private String comicServerPath;
    @TableField("comicPhysicalDirectoryName")
    private String comicPhysicalDirectoryName;
    @TableField("comicServerDirectoryName")
    private String comicServerDirectoryName;
    @TableField("addTime")
    private String addTime;
    @TableField("title")
    private String title;
    @TableField("remark")
    private String remark;
}

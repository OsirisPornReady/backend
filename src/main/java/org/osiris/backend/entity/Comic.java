package org.osiris.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("Comic")
@Data
public class Comic {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    @TableField("titleEng")
    private String titleEng;
//    @TableField("onStorage")
//    private Boolean onStorage;
//    @TableField("existSerialNumber")
//    private Boolean existSerialNumber;
//    @TableField("serialNumber")
//    private String serialNumber;
//    @TableField("videoType")
//    private Integer videoType;
//    @TableField("videoResolution")
//    private Integer videoResolution;
//    @TableField("publishTime")
//    private String publishTime;
//    private Integer duration;
//    private String director;
//    private String producer;
//    private String releaser;
//    private String brand;
//    @TableField("inSeries")
//    private Boolean inSeries;
//    private String series;
//    private String tags;
//    private String stars;
//    @TableField("tagsRaw")
//    private String tagsRaw;
//    @TableField("starsRaw")
//    private String starsRaw;
//    private String description;
//    @TableField("onSubscription")
//    private Boolean onSubscription;
//    @TableField("canCrawl")
//    private Boolean canCrawl;
//    @TableField("crawlApiUrl")
//    private String crawlApiUrl;
//    @TableField("crawlKey")
//    private String crawlKey;
//    @TableField("addTime")
//    private String addTime;
//    @TableField("updateTime")
//    private String updateTime;
//    @TableField("videoSrc")
//    private String videoSrc;
//    private Integer score;
//    @TableField("coverSrc")
//    private String coverSrc;
//    @TableField("previewImageSrcList")
//    private String previewImageSrcList;
//    @TableField("localCoverSrc")
//    private String localCoverSrc;
//    @TableField("localPreviewImageSrcList")
//    private String localPreviewImageSrcList;
//    @TableField("dataSourceUrl")
//    private String dataSourceUrl;
//    @TableField("btdigUrl")
//    private String btdigUrl;
//    private String comment;
}

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
    @TableField("canCrawl")
    private Boolean canCrawl;
    @TableField("crawlApiUrl")
    private String crawlApiUrl;
    @TableField("crawlKey")
    private String crawlKey;
    private String title;
    @TableField("titleJap")
    private String titleJap;
    private Integer score;
    @TableField("pageSize")
    private Integer pageSize;
    @TableField("languageTags")
    private String languageTags;
    @TableField("parodyTags")
    private String parodyTags;
    @TableField("characterTags")
    private String characterTags;
    @TableField("groupTags")
    private String groupTags;
    @TableField("artistTags")
    private String artistTags;
    @TableField("maleTags")
    private String maleTags;
    @TableField("femaleTags")
    private String femaleTags;
    @TableField("mixedTags")
    private String mixedTags;
    @TableField("otherTags")
    private String otherTags;
    @TableField("onStorage")
    private Boolean onStorage;
    @TableField("comicSrc")
    private String comicSrc;
    @TableField("comicResolution")
    private Integer comicResolution;
    @TableField("postedTime")
    private String postedTime;
    @TableField("comicType")
    private Integer comicType;
    @TableField("inSeries")
    private Boolean inSeries;
    private String series;
    private String description;
    @TableField("coverSrc")
    private String coverSrc;
    @TableField("previewImageSrcList")
    private String previewImageSrcList;
    @TableField("localCoverSrc")
    private String localCoverSrc;
    @TableField("localPreviewImageSrcList")
    private String localPreviewImageSrcList;
    @TableField("dataSourceUrl")
    private String dataSourceUrl;
    private String comment;
    @TableField("addTime")
    private String addTime;
    @TableField("updateTime")
    private String updateTime;
    @TableField("secureFileName")
    private String secureFileName;
    @TableField("comicPicLinkList")
    private String comicPicLinkList;
    @TableField("comicFailOrderList")
    private String comicFailOrderList;
    @TableField("localComicPicSrcList")
    private String localComicPicSrcList;
    @TableField("existSeed")
    private Boolean existSeed;
    @TableField("comicPhysicalPath")
    private String comicPhysicalPath;
    @TableField("comicServerPath")
    private String comicServerPath;
    @TableField("comicPhysicalDirectoryName")
    private String comicPhysicalDirectoryName;
    @TableField("comicServerDirectoryName")
    private String comicServerDirectoryName;
    @TableField("onlyCrawlInfo")
    private Boolean onlyCrawlInfo;
    @TableField("coverBase64")
    private String coverBase64;
    @TableField("integrity")
    private Boolean integrity;
    @TableField("chineseTitle")
    private String chineseTitle;
    @TableField("customTags")
    private String customTags;
}

package org.osiris.backend.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ComicDTO {
    private Integer id;
    private Boolean canCrawl;
    private String crawlApiUrl;
    private String crawlKey;
    private String title;
    private String titleJap;
    private Integer score;
    private Integer pageSize;
    private List<String> languageTags;
    private List<String> parodyTags;
    private List<String> characterTags;
    private List<String> groupTags;
    private List<String> artistTags;
    private List<String> maleTags;
    private List<String> femaleTags;
    private List<String> mixedTags;
    private List<String> otherTags;
    private Boolean onStorage;
    private List<String> comicSrc;
    private Integer comicResolution;
    private Date postedTime;
    private Integer comicType;
    private Boolean inSeries;
    private List<String> series;
    private String description;
    private String coverSrc;
    private List<String> previewImageSrcList;
    private String localCoverSrc;
    private List<String> localPreviewImageSrcList;
    private String dataSourceUrl;
    private String comment;
    private Date addTime;
    private Date updateTime;
    private String secureFileName;
    private List<String> comicPicLinkList;
    private List<String> comicFailOrderList;
    private List<String> localComicPicSrcList;
    private Boolean existSeed;
    private String comicPhysicalPath;
    private String comicServerPath;
    private String comicPhysicalDirectoryName;
    private String comicServerDirectoryName;
    private Boolean onlyCrawlInfo;
    private String coverBase64;
    private Boolean integrity;
    private String chineseTitle;
    private List<String> customTags;
}

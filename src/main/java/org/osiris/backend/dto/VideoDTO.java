package org.osiris.backend.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VideoDTO {
    private Integer id;
    private String title;
    private Boolean onStorage;
    private Boolean existSerialNumber;
    private String serialNumber;
    private Integer videoType;
    private Integer videoResolution;
    private Date publishTime;
    private Integer duration;
    private String director;
    private String producer;
    private String releaser;
    private String brand;
    private Boolean inSeries;
    private List<String> series;
    private List<Integer> tags;
    private List<Integer> stars;
    private List<String> tagsRaw;
    private List<String> starsRaw;
    private String description;
    private Boolean onSubscription;
    private Boolean canCrawl;
    private String crawlApiUrl;
    private String crawlKey;
    private Date addTime;
    private Date updateTime;
    private List<String> videoSrc;
    private Integer score;
    private String coverSrc;
    private List<String> previewImageSrcList;
    private String localCoverSrc;
    private List<String> localPreviewImageSrcList;
    private String dataSourceUrl;
    private String btdigUrl;
    private String comment;
    private String imagePhysicalPath;
    private String imageServerPath;
    private String imagePhysicalDirectoryName;
    private String imageServerDirectoryName;
}

package org.osiris.backend.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VideoDTO {
    private Integer id;
    private String title;
    private boolean onStorage;
    private boolean existSerialNumber;
    private String serialNumber;
    private Integer videoType;
    private Integer videoResolution;
    private Date publishTime;
    private Integer duration;
    private String director;
    private String producer;
    private String releaser;
    private String brand;
    private boolean inSeries;
    private String series;
    private List<Integer> tags;
    private List<Integer> stars;
    private String description;
    private boolean onSubscription;
}

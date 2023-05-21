package org.osiris.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class VideoCollectDTO {
    private Integer id;
    private List<Integer> albumList;
    private List<Integer> removeFromList;
    private List<Integer> addToList;
}

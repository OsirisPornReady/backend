package org.osiris.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class ComicAlbumDTO {
    private Integer id;
    private String albumName;
    private List<Integer> albumComicIdList;
}

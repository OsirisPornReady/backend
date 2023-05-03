package org.osiris.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class STResDTO {
    private List<?> list;
    private long total;
}

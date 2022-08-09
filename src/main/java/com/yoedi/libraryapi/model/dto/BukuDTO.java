package com.yoedi.libraryapi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BukuDTO {

    private String namaBuku;
    private String category;
}

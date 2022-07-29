package com.alkemy.disney.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFiltersDto {

    private String title, genreId, order;

    public MovieFiltersDto(String title, String genreId, String order) {
        this.title=title;
        this.genreId=genreId;
        this.order=order;
    }
}

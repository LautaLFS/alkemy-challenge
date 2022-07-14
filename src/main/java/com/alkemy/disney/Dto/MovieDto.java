package com.alkemy.disney.Dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class MovieDto {
    private Long id;

    private String image;

    private String title;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;

    private int rate;

    //genre_id
    private Long genre;

    private Set<CharacterDto> characters = new HashSet<>();



}

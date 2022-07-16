package com.alkemy.disney.Dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CharacterDto {
    private Long id;
    private String name;
    private String history;
    private String image;
    private long weight;
    private int age;
    private boolean deleted;
    private Set<MovieDto> movies = new HashSet<>();


}

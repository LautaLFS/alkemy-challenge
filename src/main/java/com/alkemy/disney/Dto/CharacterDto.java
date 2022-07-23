package com.alkemy.disney.Dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CharacterDto {
    private Long id;
    @NonNull
    private String name;
    private String history;
    @NonNull
    private String image;
    private long weight;
    private int age;
    private boolean deleted;
    private Set<MovieDto> movies = new HashSet<>();


}

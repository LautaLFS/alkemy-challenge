package com.alkemy.disney.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CharacterDto {
    private Long id;
    @NotNull
    private String name;
    private String history;
    @NotNull
    private String image;
    private long weight;
    private int age;
    private boolean deleted;
    private Set<MovieDto> movies = new HashSet<>();


}

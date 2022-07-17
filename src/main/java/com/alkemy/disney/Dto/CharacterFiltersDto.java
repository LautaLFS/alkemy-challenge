package com.alkemy.disney.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class CharacterFiltersDto {
    private Set<Long> movieId;
    private String name;
    private String age;

    public CharacterFiltersDto(Set<Long> movieId, String name, String age) {
        this.movieId = movieId;
        this.name = name;
        this.age = age;
    }
}

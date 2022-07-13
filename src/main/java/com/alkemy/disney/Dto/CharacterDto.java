package com.alkemy.disney.Dto;

import lombok.Data;

@Data
public class CharacterDto {
    private Long id;
    private String name;
    private String history;
    private String image;
    private long weight;
    private int age;

}

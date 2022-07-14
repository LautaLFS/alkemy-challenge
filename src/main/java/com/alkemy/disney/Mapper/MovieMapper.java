package com.alkemy.disney.Mapper;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MovieMapper {
    @Autowired
    private CharacterMapper CharacterMapper;

    public MovieEntity movieDTO2Entity(MovieDto movieDto) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieDto.getTitle());
        movieEntity.setImage(movieDto.getImage());
        movieEntity.setDate(movieDto.getDate());
        movieEntity.setGenreId(movieDto.getGenre());
        movieEntity.setRate(movieDto.getRate());
        Set<CharacterEntity> chracters = addCharactersE(movieDto.getCharacters());
        movieEntity.setCharacters(chracters);
        return movieEntity;
    }

    private Set<CharacterEntity> addCharactersE(Set<CharacterDto> characters) {
        Set<CharacterEntity> added = new HashSet<>();
        for (CharacterDto character : characters) {
            added.add(CharacterMapper.characterDto2Entity(character));
        }
        return added;
    }

    public MovieDto movieEntity2DTO(MovieEntity save) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(save.getId());
        movieDto.setTitle(save.getTitle());
        movieDto.setImage(save.getImage());
        movieDto.setDate(save.getDate());
        movieDto.setGenre(save.getGenreId());
        movieDto.setRate(save.getRate());
        Set<CharacterDto> chracters = addCharactersDTO(save.getCharacters());
        movieDto.setCharacters(chracters);
        return movieDto;
    }

    private Set<CharacterDto> addCharactersDTO(Set<CharacterEntity> characters) {
        Set<CharacterDto> added = new HashSet<>();
        for (CharacterEntity character : characters) {
            added.add(CharacterMapper.characterEntity2Dto(character));
        }
        return added;
    }

}


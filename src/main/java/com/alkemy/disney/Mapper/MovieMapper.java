package com.alkemy.disney.Mapper;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MovieMapper {
    @Autowired
    private CharacterMapper CharacterMapper;
    @Autowired
    private MovieMapper MovieMapper;

    public MovieEntity movieDTO2Entity(MovieDto movieDto) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieDto.getTitle());
        movieEntity.setImage(movieDto.getImage());
        movieEntity.setDate(movieDto.getDate());
        movieEntity.setGenreId(movieDto.getGenre());
        movieEntity.setRate(movieDto.getRate());
        Set<CharacterEntity> character = addCharactersE(movieDto.getCharacters());
        movieEntity.setCharacters(character);
        return movieEntity;
    }

    private Set<CharacterEntity> addCharactersE(Set<CharacterDto> characters) {
        Set<CharacterEntity> added = new HashSet<>();
        for (CharacterDto character : characters) {
            added.add(CharacterMapper.characterDto2Entity(character));
        }
        return added;
    }

    public MovieDto movieEntity2DTO(MovieEntity save, boolean loadCharacters) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(save.getId());
        movieDto.setTitle(save.getTitle());
        movieDto.setImage(save.getImage());
        movieDto.setDate(save.getDate());
        movieDto.setGenre(save.getGenreId());
        movieDto.setRate(save.getRate());
        if(loadCharacters) {
            Set<CharacterDto> characters = CharacterMapper.addCharactersDTO(save.getCharacters(), false);
            movieDto.setCharacters(characters);
        }
        return movieDto;
    }

    /*private Set<CharacterDto> addCharactersDTO(Set<CharacterEntity> characters, boolean loadMovies) {
        Set<CharacterDto> added = new HashSet<>();
        for (CharacterEntity character : characters) {
            added.add(CharacterMapper.characterEntity2Dto(character, loadMovies));
        }
        return added;
    }*/

    public Set<MovieDto> movieEntiy2DTOSet(Set<MovieEntity> movies, boolean loadCharacters) {
        Set<MovieDto> dtos = new HashSet<>();
        for (MovieEntity movie: movies){
            dtos.add(MovieMapper.movieEntity2DTO(movie,loadCharacters));
        }
        return dtos;
    }

    public Set<MovieEntity> MovieDTO2entitySet(Set<MovieDto> movies) {
        Set<MovieEntity> entities = new HashSet<>();
        for (MovieDto movie: movies){
            entities.add(MovieMapper.movieDTO2Entity(movie));
        }
        return  entities;
    }

    public MovieDto MovieEntity2DTOSet(MovieEntity save) {

        return null;
    }

    public List<MovieDto> MovieEntity2DTOList(List<MovieEntity> movies, boolean loadCharacters) {
        List<MovieDto> dtos = new ArrayList<>();
        for (MovieEntity movie: movies){
            dtos.add(MovieMapper.movieEntity2DTO(movie, loadCharacters));
        }
        return dtos;
    }
}


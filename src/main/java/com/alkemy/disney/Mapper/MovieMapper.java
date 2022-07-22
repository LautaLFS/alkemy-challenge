package com.alkemy.disney.Mapper;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Entity.MovieEntity;
import com.alkemy.disney.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MovieMapper {
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private MovieMapper MovieMapper;
    @Autowired
    private GenreRepository genreRepository;

    public MovieEntity movieDTO2Entity(MovieDto movieDto) {
        MovieEntity movieEntity = new MovieEntity();
        return loadEntity(movieEntity, movieDto);
    }

    private Set<CharacterEntity> addCharactersE(Set<CharacterDto> characters) {
        Set<CharacterEntity> added = new HashSet<>();
        for (CharacterDto character : characters) {
            added.add(characterMapper.characterDto2Entity(character));
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
            Set<CharacterDto> characters = characterMapper.addCharactersDTO(save.getCharacters(), false);
            movieDto.setCharacters(characters);
        }
        return movieDto;
    }

    public Set<MovieDto> movieEntity2DTOSet(Set<MovieEntity> movies, boolean loadCharacters) {
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

    public MovieEntity loadEntity(MovieEntity entity, MovieDto movieDto) {
        entity.setTitle(movieDto.getTitle());
        entity.setImage(movieDto.getImage());
        entity.setDate(movieDto.getDate());
        entity.setGenre(genreRepository.findById(movieDto.getGenre()).get());
        entity.setGenreId(movieDto.getGenre());
        entity.setRate(movieDto.getRate());
        Set<CharacterEntity> character = addCharactersE(movieDto.getCharacters());
        entity.setCharacters(character);
        return entity;
    }
}


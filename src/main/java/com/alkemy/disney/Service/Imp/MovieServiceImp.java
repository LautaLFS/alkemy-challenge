package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Dto.MovieBasicDto;
import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Dto.MovieFiltersDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Entity.MovieEntity;
import com.alkemy.disney.Exception.ParamNotFound;
import com.alkemy.disney.Mapper.MovieMapper;
import com.alkemy.disney.Repository.CharacterRepository;
import com.alkemy.disney.Repository.MovieRepository;
import com.alkemy.disney.Repository.Specification.MovieSpecification;
import com.alkemy.disney.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService {
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieSpecification movieSpecification;
    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public MovieDto save(MovieDto movieDto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(movieDto);
        MovieEntity movieSaved = this.movieRepository.save(entity);
        return movieMapper.movieEntity2DTO(movieSaved, true);
    }

    @Override
    public MovieDto update(MovieDto movieDto, Long id) {
        MovieEntity entity = movieRepository.findById(id).orElseThrow(
                ()-> new ParamNotFound("Invalid id: provide id is not found"));
        return movieMapper.movieEntity2DTO(movieRepository.save(
                movieMapper.updateMovie(entity, movieDto)), false);
    }

    @Override
    public void delete(Long id) {
        MovieEntity entity = movieRepository.findById(id).orElseThrow(
                ()-> new ParamNotFound("ID NOT FOUND")
        );
        movieRepository.delete(entity);
    }
    @Override
    public MovieDto findById(Long id) {
        MovieEntity movieEntity = movieRepository.findById(id).orElseThrow(
                ()-> new ParamNotFound("ID NOT FOUND"));
        return movieMapper.movieEntity2DTO(movieEntity, true);
    }

    @Override
    public List<MovieBasicDto> findByFilters(String title, String genreId, String order) {
        MovieFiltersDto filtersDto = new MovieFiltersDto(title, genreId, order);
        List<MovieEntity> entities = movieRepository.findAll(movieSpecification.getByFilters(filtersDto));
        return movieMapper.MovieBasicEntity2DTOList(entities);
    }

    @Override
    public MovieDto addCharacter(Long idMovie, Long idCharacter) {
        MovieEntity movieEntity = movieRepository.findById(idMovie).orElseThrow(
                ()-> new ParamNotFound("ID NOT FOUND"));
        CharacterEntity characterEntity = characterRepository.findById(idCharacter).orElseThrow(
                ()-> new ParamNotFound("ID NOT FOUND")
        );
        movieEntity.addCharacter(characterEntity);
        return movieMapper.movieEntity2DTO(movieRepository.save(movieEntity), true);
    }

    @Override
    public MovieDto removeCharacter(Long idMovie, Long idCharacter) {
        MovieEntity movieEntity = movieRepository.findById(idMovie).orElseThrow(
                ()-> new ParamNotFound("ID NOT FOUND"));
        CharacterEntity characterEntity = characterRepository.findById(idCharacter).orElseThrow(
                ()-> new ParamNotFound("ID NOT FOUND")
        );
        movieEntity.removeCharacter(characterEntity);
        return movieMapper.movieEntity2DTO(movieRepository.save(movieEntity), true);
    }
}

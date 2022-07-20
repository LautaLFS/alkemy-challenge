package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Dto.MovieFiltersDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Entity.MovieEntity;
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
        MovieEntity entity = movieRepository.getById(id);

        entity.setImage(movieDto.getImage());
        entity.setGenreId(movieDto.getGenre());
        entity.setDate(movieDto.getDate());
        entity.setTitle(movieDto.getTitle());
        entity.setRate(movieDto.getRate());

        return movieMapper.movieEntity2DTO(movieRepository.save(entity), true);
    }

    @Override
    public void delete(Long id) {
        MovieEntity entity = movieRepository.getById(id);
        movieRepository.delete(entity);

    }

    @Override
    public List<MovieDto> findAll() {
        List<MovieEntity> movies = movieRepository.findAll();
        return movieMapper.MovieEntity2DTOList(movies, true);
    }

    @Override
    public MovieDto findById(Long id) {
        MovieEntity entity = movieRepository.getById(id);
        return movieMapper.movieEntity2DTO(entity, true);
    }

    @Override
    public List<MovieDto> findByFilters(String title, String genreId, String order) {
        MovieFiltersDto filtersDto = new MovieFiltersDto(title, genreId, order);
        List<MovieEntity> entities = movieRepository.findAll(movieSpecification.getByFilters(filtersDto));

        return movieMapper.MovieEntity2DTOList(entities, true);
    }

    @Override
    public MovieDto addCharacter(Long idMovie, Long idCharacter) {
        MovieEntity movieEntity = movieRepository.getById(idMovie);
        CharacterEntity characterEntity = characterRepository.getById(idCharacter);
        movieEntity.addCharacter(characterEntity);

        return movieMapper.movieEntity2DTO(movieRepository.save(movieEntity), true);

    }

    @Override
    public MovieDto removeCharacter(Long idMovie, Long idCharacter) {
        MovieEntity movieEntity = movieRepository.getById(idMovie);
        CharacterEntity characterEntity = characterRepository.getById(idCharacter);
        movieEntity.removeCharacter(characterEntity);

        return movieMapper.movieEntity2DTO(movieRepository.save(movieEntity), true);
    }
}

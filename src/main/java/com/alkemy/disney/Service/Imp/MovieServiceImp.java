package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Entity.MovieEntity;
import com.alkemy.disney.Mapper.CharacterMapper;
import com.alkemy.disney.Mapper.MovieMapper;
import com.alkemy.disney.Repository.MovieRepository;
import com.alkemy.disney.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService {
    @Autowired
    private MovieMapper MovieMapper;
    @Autowired
    private MovieRepository MovieRepository;


    @Override
    public MovieDto save(MovieDto movieDto) {
        MovieEntity entity = MovieMapper.movieDTO2Entity(movieDto);
        MovieEntity movieSaved = this.MovieRepository.save(entity);
        return MovieMapper.movieEntity2DTO(movieSaved, true);
    }

    @Override
    public MovieDto update(MovieDto movieDto, Long id) {

        MovieEntity entity = MovieRepository.getById(id);

        entity.setImage(movieDto.getImage());
        entity.setGenreId(movieDto.getGenre());
        entity.setDate(movieDto.getDate());
        entity.setTitle(movieDto.getTitle());
        entity.setRate(movieDto.getRate());

        return MovieMapper.movieEntity2DTO(MovieRepository.save(entity), true);
    }

    @Override
    public void delete(Long id) {
        MovieEntity entity = MovieRepository.getById(id);
        MovieRepository.delete(entity);

    }

    @Override
    public List<MovieDto> findAll() {
        List<MovieEntity> movies = MovieRepository.findAll();

        return MovieMapper.MovieEntity2DTOList(movies, true);
    }

    @Override
    public MovieDto findById(Long id) {
        MovieEntity entity = MovieRepository.getById(id);
        return MovieMapper.movieEntity2DTO(entity, true);
    }
}

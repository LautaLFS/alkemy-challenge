package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Entity.MovieEntity;
import com.alkemy.disney.Mapper.MovieMapper;
import com.alkemy.disney.Repository.MovieRepository;
import com.alkemy.disney.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return MovieMapper.movieEntity2DTO(movieSaved);
    }

    @Override
    public MovieDto update(MovieDto movieDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<MovieDto> findAll() {
        return null;
    }

    @Override
    public MovieDto findById(Long id) {
        return null;
    }
}

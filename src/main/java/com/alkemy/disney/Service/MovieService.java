package com.alkemy.disney.Service;

import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Entity.MovieEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    MovieDto save(MovieDto movieDto);

    MovieDto update(MovieDto movieDto, Long id);

    void delete(Long id);

    List<MovieDto> findAll();

    MovieDto findById(Long id);

    List<MovieDto> findByFilters(String title, String genreId, String order);
}

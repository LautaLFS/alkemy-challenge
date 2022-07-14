package com.alkemy.disney.Service;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    MovieDto save(MovieDto movieDto);

    MovieDto update(MovieDto movieDto, Long id);

    void delete(Long id);

    List<MovieDto> findAll();

    MovieDto findById(Long id);
}
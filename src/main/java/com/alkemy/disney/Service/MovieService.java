package com.alkemy.disney.Service;

import com.alkemy.disney.Dto.MovieBasicDto;
import com.alkemy.disney.Dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    MovieDto save(MovieDto movieDto);

    MovieDto update(MovieDto movieDto, Long id);

    void delete(Long id);

    MovieDto findById(Long id);

    List<MovieBasicDto> findByFilters(String title, String genreId, String order);

    MovieDto addCharacter(Long idMovie, Long idCharacter);

    MovieDto removeCharacter(Long idMovie, Long idCharacter);
}

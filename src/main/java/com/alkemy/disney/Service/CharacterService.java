package com.alkemy.disney.Service;

import com.alkemy.disney.Dto.CharacterBasicDto;
import com.alkemy.disney.Dto.CharacterDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface CharacterService {
    public CharacterDto save(CharacterDto dto);
    CharacterDto update(CharacterDto characterDto, Long id);
    void delete(Long id);
    CharacterDto findById(Long id);
    List<CharacterBasicDto> findByFilters(String name, String age, Set<Long> movieID);
}

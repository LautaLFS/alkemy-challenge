package com.alkemy.disney.Service;

import com.alkemy.disney.Dto.CharacterDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CharacterService {
    public CharacterDto save(CharacterDto dto);

    CharacterDto update(CharacterDto characterDto, Long id);

    void delete(Long id);

    List<CharacterDto> findAll();

    CharacterDto findById(Long id);
}

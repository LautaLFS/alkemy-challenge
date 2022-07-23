package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Dto.CharacterBasicDto;
import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Dto.CharacterFiltersDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Mapper.CharacterMapper;
import com.alkemy.disney.Repository.CharacterRepository;
import com.alkemy.disney.Repository.Specification.CharacterSpecification;
import com.alkemy.disney.Service.CharacterService;
import com.alkemy.disney.exception.ParamNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service

public class CharacterServiceImp implements CharacterService {
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterSpecification characterSpecification;


    //TODO: AGREGAR SI CARGAR O NO LAS PELICULAS
    @Override
    public CharacterDto save(CharacterDto dto) {
        CharacterEntity characterEntity = characterMapper.characterDto2Entity(dto);
        CharacterEntity entitySaved = this.characterRepository.save(characterEntity);
        return this.characterMapper.characterEntity2Dto(entitySaved, false);
    }

    @Override
    public CharacterDto update(CharacterDto characterDto, Long id) {
        CharacterEntity entity = characterRepository.findById(id).orElseThrow(
                ()->new ParamNotFound("Character not found. Id: "+id+" not found"));
        return characterMapper.characterEntity2Dto(characterRepository.save(
                characterMapper.loadEntity(entity, characterDto)), true);
    }
    @Override
    public void delete(Long id) {
        CharacterEntity entity = characterRepository.findById(id).orElseThrow(
                ()->new ParamNotFound("Character not found. Id: "+id+" not found"));
        characterRepository.delete(entity);
    }
    @Override
    public CharacterDto findById(Long id) {
        Optional<CharacterEntity> found = characterRepository.findById(id);
        if (!found.isPresent()){
            throw new ParamNotFound("Invalid character id");
        }
        return characterMapper.characterEntity2Dto(found.get(), true);
    }

    @Override
    public List<CharacterBasicDto> findByFilters(String name, String age, Set<Long> movieId) {
        CharacterFiltersDto filtersDto = new CharacterFiltersDto(movieId, name, age);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDto));
        return characterMapper.characterBasicEntity2DtoList(entities, false);
    }

}

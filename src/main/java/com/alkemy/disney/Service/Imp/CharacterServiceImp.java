package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Dto.CharacterFiltersDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Mapper.CharacterMapper;
import com.alkemy.disney.Repository.CharacterRepository;
import com.alkemy.disney.Repository.Specification.CharacterSpecification;
import com.alkemy.disney.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        CharacterEntity entity = characterRepository.getById(id);
        entity.setWeight(characterDto.getWeight());
        entity.setName(characterDto.getName());
        entity.setHistory(characterDto.getHistory());
        entity.setImage(characterDto.getImage());
        entity.setAge(characterDto.getAge());

        return characterMapper.characterEntity2Dto(characterRepository.save(entity), true);
    }

    @Override
    public void delete(Long id) {
        CharacterEntity entity = characterRepository.getById(id);
        characterRepository.delete(entity);

    }

    @Override
    public List<CharacterDto> findAll() {
        List<CharacterEntity> entities = characterRepository.findAll();
        return characterMapper.characterEntity2DtoList(entities, true);
    }
    @Override
    public CharacterDto findById(Long id) {
        CharacterEntity found = characterRepository.getById(id);
        return characterMapper.characterEntity2Dto(found, true);
    }

    @Override
    public List<CharacterDto> findByFilters(String name, String age, Set<Long> movieId) {

        CharacterFiltersDto filtersDto = new CharacterFiltersDto(movieId, name, age);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDto));

        return characterMapper.characterEntity2DtoList(entities, true);
    }

}

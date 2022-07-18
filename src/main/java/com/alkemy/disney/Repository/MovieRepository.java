package com.alkemy.disney.Repository;

import com.alkemy.disney.Dto.MovieFiltersDto;
import com.alkemy.disney.Entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>, JpaSpecificationExecutor<MovieEntity> {

    @Override
    List<MovieEntity> findAll(Specification<MovieEntity> spc);
}

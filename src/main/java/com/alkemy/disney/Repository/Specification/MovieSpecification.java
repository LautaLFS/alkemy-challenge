package com.alkemy.disney.Repository.Specification;

import com.alkemy.disney.Dto.MovieFiltersDto;
import com.alkemy.disney.Entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieSpecification {
    public Specification<MovieEntity> getByFilters(MovieFiltersDto filtersDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDto.getTitle())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%"+ filtersDto.getTitle().toLowerCase() + "%"
                        )
                );
            }
            if(StringUtils.hasLength(filtersDto.getGenreId())){
                Long id = Long.valueOf(filtersDto.getGenreId());
                predicates.add(
                        criteriaBuilder.equal(root.get("genre"), id)
                );

            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

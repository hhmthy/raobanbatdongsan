package com.hhmthy.newscat.repository;

import com.hhmthy.newscat.entity.NewsCatEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "newscat", path = "list")
public interface NewsCatRepository extends PagingAndSortingRepository<NewsCatEntity, Long> {

    @RestResource(path = "byName", rel = "newscat")
    List<NewsCatEntity> findNewsCatEntitiesByNameCatContaining(@Param("namecat") String namecat);
}

package com.hhmthy.news.repository;

import com.hhmthy.news.entity.NewsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "news", path = "list")
public interface NewsRepository extends PagingAndSortingRepository<NewsEntity, Long> {

    @RestResource(path = "byTitle", rel = "news")
    List<NewsEntity> findByNewsTitleContaining(@Param("title") String title);

    @RestResource(path = "byTitleAndContent", rel = "news")
    List<NewsEntity> findNewsEntitiesByNewsTitleContainingAndAndNewsContentContaining(@Param("title") String title, @Param("content") String content);
}

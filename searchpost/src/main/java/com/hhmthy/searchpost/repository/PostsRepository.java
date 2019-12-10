package com.hhmthy.searchpost.repository;

import com.hhmthy.searchpost.entity.Posts1Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "timkiem", path = "result")
public interface PostsRepository extends PagingAndSortingRepository<Posts1Entity, Long> {
    @RestResource(path = "byPrice", rel = "price")
    Page<Posts1Entity> findByPriceBetween(@Param("a") Integer a, @Param("b") Integer b, Pageable pageable);

    @RestResource(path = "byArea", rel = "area")
    Page<Posts1Entity> findByAreaBetween(@Param("a") Integer a, @Param("b") Integer b, Pageable pageable);

    @RestResource(path = "byCer", rel = "cer")
    Page<Posts1Entity> findByCertificationContaining(@Param("cer") String cer, Pageable pageable);

    @RestResource(path = "byCity", rel = "city")
    Page<Posts1Entity> findByCityContaining(@Param("city") String city, Pageable pageable);

    @RestResource(path = "byCityDistrict", rel = "cd")
    Page<Posts1Entity> findByCityContainingAndDistrictContaining(
            @Param("city") String city, @Param("district") String district, Pageable pageable
    );

    @RestResource(path = "byTitle", rel = "title")
    Page<Posts1Entity> findByTitleContaining(@Param("title") String title, Pageable pageable);

    @RestResource(path = "byRating", rel = "rating")
    Page<Posts1Entity> findByRating(@Param("rating") Integer rating, Pageable pageable);

    @RestResource(path = "byUser", rel = "user")
    Page<Posts1Entity> findByUserId(@Param("userid") String userid, Pageable pageable);
}

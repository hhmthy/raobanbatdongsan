package com.hhmthy.statistic.repository;

import com.hhmthy.statistic.entity.Posts1Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "thongke", path = "posts")
public interface PostsRepository extends PagingAndSortingRepository<Posts1Entity, Long> {

    /*@RestResource(path = "countByCityDistrict", rel = "cd")
    Long countByCityContainingAndDistrictContaining(@Param("city") String city, @Param("district") String district);*/

    @RestResource(path = "countByUser", rel = "user")
    Long countByUserId(@Param("userid") String userid);

    @RestResource(path = "countByCity", rel = "city")
    Long countByCityContaining(@Param("city") String city);

    @RestResource(path = "countCertification", rel = "certification")
    Long countByCertificationContains(@Param("cer") String cer);

    @RestResource(path = "countCatalog", rel = "catalog")
    Long countByCatalogContaining(@Param("catalog") String catalog);

    @RestResource(path = "countAll", rel = "all")
    @Query("select count (p) from Posts1Entity p")
    Long findCount();

    /**
     * find something
     */


    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Override
    @RestResource(exported = false)
    void delete(Posts1Entity posts1Entity);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Posts1Entity> iterable);

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @Override
    @RestResource(exported = false)
    <S extends Posts1Entity> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Posts1Entity> Iterable<S> saveAll(Iterable<S> iterable);

}

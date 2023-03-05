package com.electric.demo.repository;

import com.electric.demo.model.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StationRepository extends JpaRepository<Station,Long> {
    @Query(value = "SELECT * FROM station order by id desc limit :limit", nativeQuery = true)
    public List<Station> findTopN(@Param("limit") Long limit);
}

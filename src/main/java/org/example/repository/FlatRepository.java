package org.example.repository;

import org.example.entities.Building;
import org.example.entities.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Integer> {
    @Query("select distinct e from Flat e "
            + "left join fetch e.building where e.building =:building")
    List<Flat> findAllByBuilding(Optional<Building> building);

}

package org.example.repository;

import org.example.entities.Building;
import org.example.entities.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    @Query("select distinct e from Building e "
            + "left join fetch e.street "
            + "left join fetch e.street where e.street =:street")
    List<Building> findAllByStreet(Optional<Street> street);

}

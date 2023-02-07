package org.example.services;

import org.example.entities.Flat;

import java.util.List;
import java.util.Optional;

public interface FlatService {
    public List<Flat> findAllFlats();
    public List<Flat> findAllFlatsInBuilding(int buildingId);
    public List<Flat> findAllFlatsOnStreet(int streetId);
    public Optional<Flat> findOneFlat(int id);

}

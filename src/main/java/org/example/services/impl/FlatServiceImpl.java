package org.example.services.impl;

import org.example.entities.Building;
import org.example.entities.Flat;
import org.example.entities.Street;
import org.example.repository.BuildingRepository;
import org.example.repository.FlatRepository;
import org.example.repository.StreetRepository;
import org.example.services.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlatServiceImpl implements FlatService {
    private final BuildingRepository buildingRepository;
    private final FlatRepository flatRepository;
    private final StreetRepository streetRepository;

    @Autowired
    public FlatServiceImpl(BuildingRepository buildingRepository, FlatRepository flatRepository, StreetRepository streetRepository) {
        this.buildingRepository = buildingRepository;
        this.flatRepository = flatRepository;
        this.streetRepository = streetRepository;
    }

    @Override
    public List<Flat> findAllFlats() {
        return flatRepository.findAll();
    }

    @Override
    public List<Flat> findAllFlatsInBuilding(int buildingId) {
        Optional<Building> building = buildingRepository.findById(buildingId);
        return flatRepository.findAllByBuilding(building);
    }

    @Override
    public List<Flat> findAllFlatsOnStreet(int flatId) {
        Optional<Street> street = streetRepository.findById(flatId);
        List<Building> buildings = buildingRepository.findAllByStreet(street);
        List<Flat> flats = new ArrayList<>();
        for (Building b:buildings) {
            flats.addAll(flatRepository.findAllByBuilding(Optional.ofNullable(b)));
        }
        return flats;
    }

    @Override
    public Optional<Flat> findOneFlat(int id) {
        return flatRepository.findById(id);
    }
}

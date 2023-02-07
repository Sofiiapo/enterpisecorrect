package org.example.controllers;

import org.example.entities.Flat;
import org.example.services.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "flats")
public class FlatController {
    private final FlatService flatService;

    @Autowired
    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping()
    public List<Flat> allFlats(){
        return flatService.findAllFlats();
    }

    @GetMapping(value = "/building")
    public List<Flat> allFlatsInBuilding(@RequestParam int buildingId){
        return flatService.findAllFlatsInBuilding(buildingId);
    }

    @GetMapping(value = "/street")
    public List<Flat> allFlatsByStreet(@RequestParam int streetId){
        return flatService.findAllFlatsOnStreet(streetId);
    }

    @GetMapping(value = "findOne")
    public Flat findOne(@RequestParam int id){
        return flatService.findOneFlat(id)
                .get();
    }
}

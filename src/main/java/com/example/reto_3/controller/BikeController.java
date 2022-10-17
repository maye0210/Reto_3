package com.example.reto_3.controller;

import com.example.reto_3.entities.Bike;
import com.example.reto_3.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/Bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/all")
    public List<Bike> getBikes(){
        return bikeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Bike> getBike(@PathVariable("id") int bikeId) {
        return bikeService.getBike(bikeId);
    }

    @GetMapping("/{doc}")
    public Optional<Bike> findById(@PathVariable("doc") int doc) {
        return bikeService.getBike(doc);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody  Bike bike){
        return bikeService.save(bike);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody  Bike bike){ return bikeService.update(bike); }

    @DeleteMapping("/{doc}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("doc") int doc) { return bikeService.delete(doc); }

}

package com.example.reto_3.controller;

import com.example.reto_3.entities.Bike;
import com.example.reto_3.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/all")
    public List<Bike> getAll(){
        return bikeService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody  Bike p){
        return bikeService.save(p);
    }
}

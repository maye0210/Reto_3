package com.example.reto_3.repository;

import com.example.reto_3.entities.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BikeRepository {
    @Autowired
    private BikeCrudRepository bikeCrudRepository;

    public List<Bike> getAll(){
        return (List<Bike>) bikeCrudRepository.findAll();
    }

    public Optional<Bike> getBike(int id){
        return bikeCrudRepository.findById(id);
    }
    public Bike save(Bike c){
        return bikeCrudRepository.save(c);
    }
    public void delete(Bike c){
        bikeCrudRepository.delete(c);
    }

}

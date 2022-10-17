package com.example.reto_3.service;

import com.example.reto_3.entities.Bike;
import com.example.reto_3.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.getAll(); }
    public Optional<Bike> getBike(int bikeId){
        return bikeRepository.getBike(bikeId);
    }
    public Bike save(Bike bike){
        if(bike.getId()==null){
            return bikeRepository.save(bike);
        }else{
            Optional<Bike> e = bikeRepository.getBike(bike.getId());
            if(e.isPresent()){
                return bike;
            }else{
                return bikeRepository.save(bike);
            }
        }
    }
    public Bike update(Bike bike) {
        if (bike.getId() != null) {
            Optional<Bike> q = bikeRepository.getBike(bike.getId());
            if (q.isPresent()) {
                if (bike.getName() != null) {
                    q.get().setName(bike.getName());
                }
                if (bike.getBrand() != null) {
                    q.get().setBrand(bike.getBrand());
                }
                if (bike.getYear() != null) {
                    q.get().setYear(bike.getYear());
                }
                if (bike.getDescription() != null) {
                    q.get().setDescription(bike.getDescription());
                }
                if (bike.getCategory() != null) {
                    q.get().setCategory(bike.getCategory());
                }
                if (bike.getMessages() != null) {
                    q.get().setMessages(bike.getMessages());
                }
                if (bike.getReservations() != null) {
                    q.get().setReservations(bike.getReservations());
                }

                bikeRepository.save(q.get());
                return q.get();
            } else {
                return bike;
            }
        }else{
            return bike;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Bike>p= bikeRepository.getBike(id);
        if(p.isPresent()){
            bikeRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}


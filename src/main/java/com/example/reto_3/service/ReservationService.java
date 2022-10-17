package com.example.reto_3.service;

import com.example.reto_3.entities.Reservation;
import com.example.reto_3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int reservationId){
        return reservationRepository.getReservation(reservationId);
    }
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> e =reservationRepository.getReservation(reservation.getIdReservation());
            if(e.isPresent()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> q =reservationRepository.getReservation(reservation.getIdReservation());
            if(q.isPresent()){
                if(reservation.getIdReservation()!=null){
                    q.get().setIdReservation(reservation.getIdReservation());
                }
                if(reservation.getBike()!=null){
                    q.get().setBike(reservation.getBike());
                }
                if(reservation.getClient()!=null){
                    q.get().setClient(reservation.getClient());
                }
                if(reservation.getStartDate()!=null){
                    q.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>p=reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}


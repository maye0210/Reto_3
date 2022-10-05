package com.example.reto_3.service;

import com.example.reto_3.entities.Bike;
import com.example.reto_3.entities.Message;
import com.example.reto_3.repository.BikeRepository;
import com.example.reto_3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getBike(int id){
        return messageRepository.getBike(id);
    }
    public Message save(Message p){
        if(p.getId()==null){
            return messageRepository.save(p);
        }else{
            Optional<Message> e = messageRepository.getBike(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return messageRepository.save(p);
            }
        }
    }
    public Message update(Message p){
        if(p.getId()!=null){
            Optional<Message> q = messageRepository.getBike(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if(p.getTarget()!=null){
                    q.get().setTarget(p.getTarget());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }

                messageRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Message>p= messageRepository.getBike(id);
        if(p.isPresent()){
            messageRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}




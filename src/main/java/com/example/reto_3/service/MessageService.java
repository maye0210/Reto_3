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
    public Optional<Message> getMessage(int messageId){
        return messageRepository.getMessage(messageId);
    }
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if(e.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> q = messageRepository.getMessage(message.getIdMessage());
            if(q.isPresent()){
                if(message.getIdMessage()!=null){
                    q.get().setIdMessage(message.getIdMessage());
                }
                if(message.getMessageText()!=null){
                    q.get().setMessageText(message.getMessageText());
                }

                messageRepository.save(q.get());
                return q.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Message>p= messageRepository.getMessage(id);
        if(p.isPresent()){
            messageRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}




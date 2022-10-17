package com.example.reto_3.repository;

import com.example.reto_3.entities.Message;
import org.springframework.data.repository.CrudRepository;



public interface MessageCrudRepository extends CrudRepository <Message,String> {

}

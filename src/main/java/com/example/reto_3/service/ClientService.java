package com.example.reto_3.service;

import com.example.reto_3.entities.Client;
import com.example.reto_3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int clientId){
        return clientRepository.getClient(clientId);
    }
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if(e.isPresent()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(client.getIdClient());
            if(q.isPresent()){
                if(client.getName()!=null){
                    q.get().setName(client.getName());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>p= clientRepository.getClient(id);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}


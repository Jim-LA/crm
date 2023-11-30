package com.poec.crm.service;


import com.poec.crm.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poec.crm.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    //SELECT *
    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    //CREATE
    public void addClient(Client client){
        clientRepository.save(client);
    }
    //SELECT by Id
    public Optional<Client> findById(Integer id){
        Optional<Client> optional = clientRepository.findById(id);
        return optional;
    }
    //UPDATE by Id
    public Client updateClient(Client client){
        return clientRepository.save(client);
    }
    //DELETE client
    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }
    
}

package com.poec.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import com.poec.crm.service.ClientService;
import com.poec.crm.model.Client;


@RestController
@RequestMapping("apiClient")
public class ClientController {
    
    @Autowired
    ClientService clientService;

    //SELECT *
    @GetMapping("clients")
    public List<Client> getAll(){
        return clientService.getClients();
    }
    //CREATE
    @PostMapping("clients")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClient(@RequestBody Client client){
        clientService.addClient(client);
    }
    //SELECT by Id
    @GetMapping("client/{id}")
    public ResponseEntity<Client> findById(@PathVariable Integer id) {
       Optional<Client> optional = clientService.findById(id);
       if (optional.isEmpty()) {
        return ResponseEntity.notFound().build();
       }else{
        return ResponseEntity.ok(optional.get());
       }
    }
    //UPDATE by Id
    @PutMapping("client")
    public ResponseEntity<?> update(@RequestBody Client client){
        Client clientUpdated = clientService.updateClient(client);
        if (clientUpdated != null) {
            return ResponseEntity.status(204).body("Client mis à jour avec succès !");
        }else{
            return ResponseEntity.status(403).build();
        }

    }
    //DELETE client
    @DeleteMapping("client/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteClient(@PathVariable Integer id){
        if (clientService.findById(id).isEmpty() == true) {
            return ResponseEntity.notFound().build();
        }else{
            clientService.deleteClient(id);
            return ResponseEntity.ok().body("Le client a bien été supprimé ! ");
        }
    }

}

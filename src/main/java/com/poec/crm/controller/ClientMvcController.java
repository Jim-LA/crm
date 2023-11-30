package com.poec.crm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.poec.crm.model.Client;
import com.poec.crm.service.ClientService;

@Controller
//@RequestMapping("front")
public class ClientMvcController {
    
    @Autowired
    ClientService clientService;

    //SELECT * FROM clients
    @GetMapping("clientsFront")
    public String getClientsFront(Model model){
        model.addAttribute("clients", clientService.getClients());
        return "client.html";
    }
    //CREATE
    @PostMapping("clientsFront")
    public String addClientsFrontClient(Client client, Model model){
        clientService.addClient(client);
        model.addAttribute("clients", clientService.getClients());
        return "client.html";
    }
    //UPDATE
    @PutMapping("clientFront")
    public String updateClientFront(Client client, Model model){
        clientService.updateClient(client);
        model.addAttribute("clients", clientService.getClients());
        return "client.html";
    }




}

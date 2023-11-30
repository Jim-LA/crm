package com.poec.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poec.crm.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}

package com.quantumstudio.vinylstorerest.repositories;

import com.quantumstudio.vinylstorerest.entities.Client;
import com.quantumstudio.vinylstorerest.entities.Vinyl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

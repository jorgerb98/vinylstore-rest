package com.quantumstudio.vinylstorerest.repositories;

import com.quantumstudio.vinylstorerest.entities.Band;
import com.quantumstudio.vinylstorerest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {

}

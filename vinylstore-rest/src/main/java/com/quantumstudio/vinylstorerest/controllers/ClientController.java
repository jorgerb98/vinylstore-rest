package com.quantumstudio.vinylstorerest.controllers;

import com.quantumstudio.vinylstorerest.exceptions.DuplicateEntityException;
import com.quantumstudio.vinylstorerest.exceptions.EntityNotFoundException;
import com.quantumstudio.vinylstorerest.models.ClientModel;
import com.quantumstudio.vinylstorerest.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClientController {

	private final ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("/client")
	public List<ClientModel> findAll(){
		return (clientService.findAll());
	}
	@GetMapping("/client/{id}")
	public ClientModel findOne(@PathVariable long id) throws EntityNotFoundException {
		return clientService.findOne(id);
	}

	@PostMapping("/client")
	public ClientModel save(@Valid @RequestBody ClientModel clientModel) throws DuplicateEntityException {
		return clientService.save(clientModel);
	}
	@PutMapping("/client/{id}")
	public ClientModel update(@Valid @RequestBody ClientModel clientModel,@PathVariable long id){
		return clientService.update(clientModel,id);
	}
	@DeleteMapping("/client/{id}")
	public void delete(@Valid @PathVariable int id) throws Throwable {
		clientService.delete(id);
	}



}

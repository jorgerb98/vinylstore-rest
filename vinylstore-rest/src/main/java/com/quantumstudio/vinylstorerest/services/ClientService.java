package com.quantumstudio.vinylstorerest.services;

import com.quantumstudio.vinylstorerest.entities.Client;
import com.quantumstudio.vinylstorerest.exceptions.DuplicateEntityException;
import com.quantumstudio.vinylstorerest.exceptions.EntityNotFoundException;
import com.quantumstudio.vinylstorerest.models.ClientModel;
import com.quantumstudio.vinylstorerest.models.VinylModel;

import java.util.List;

public interface ClientService {

	ClientModel save(ClientModel clientModel) throws DuplicateEntityException;

	List<ClientModel> findAll();

	ClientModel findOne(long id) throws EntityNotFoundException;

	ClientModel update(ClientModel clientModel, long id);

	void delete(long id) throws Throwable;
}

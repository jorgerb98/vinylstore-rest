package com.quantumstudio.vinylstorerest.services.impl;

import com.quantumstudio.vinylstorerest.entities.Client;
import com.quantumstudio.vinylstorerest.entities.Vinyl;
import com.quantumstudio.vinylstorerest.exceptions.DuplicateEntityException;
import com.quantumstudio.vinylstorerest.exceptions.EntityNotFoundException;
import com.quantumstudio.vinylstorerest.models.ClientModel;
import com.quantumstudio.vinylstorerest.models.VinylModel;
import com.quantumstudio.vinylstorerest.repositories.ClientRepository;
import com.quantumstudio.vinylstorerest.repositories.VinylRepository;
import com.quantumstudio.vinylstorerest.services.ClientService;
import com.quantumstudio.vinylstorerest.services.VinylService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public ClientModel save(ClientModel clientModel) throws DuplicateEntityException {
		Optional<Client> clientOptional = clientRepository.findById(clientModel.getId());

		if (clientOptional.isPresent()) {
			throw new DuplicateEntityException();
		}

		Client client = new Client();
		client.setName(clientModel.getName());
		client.setPassword(clientModel.getPassword());
		client.setPurchaseSet(clientModel.getPurchaseSet());
		return ClientModel.from(clientRepository.save(client));

	}

	@Override
	public List<ClientModel> findAll() {
		return clientRepository.findAll()
								  .stream()
								  .map(ClientModel::from)
								  .collect(Collectors.toList());
	}

	@Override
	public ClientModel findOne(long id) throws EntityNotFoundException {
		return clientRepository.findById(id)
								  .map(ClientModel::from)
								  .orElseThrow(EntityNotFoundException::new);

	}

	@Override
	public ClientModel update(ClientModel clientModel, long id) {
		Client client = new Client();
		client.setName(clientModel.getName());
		client.setPassword(clientModel.getPassword());
		client.setPurchaseSet(clientModel.getPurchaseSet());
		return ClientModel.from(clientRepository.save(client));
	}

	@Override
	public void delete(long id) throws Throwable {
		Optional<Client> optional = clientRepository.findById(id);

		if (optional.isPresent()){
			clientRepository.delete(optional.get());
		}else throw new EntityNotFoundException();

	}
}

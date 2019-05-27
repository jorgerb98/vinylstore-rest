package com.quantumstudio.vinylstorerest.services;

import com.quantumstudio.vinylstorerest.entities.Band;
import com.quantumstudio.vinylstorerest.exceptions.DuplicateEntityException;
import com.quantumstudio.vinylstorerest.exceptions.EntityNotFoundException;
import com.quantumstudio.vinylstorerest.models.BandModel;
import com.quantumstudio.vinylstorerest.models.VinylModel;

import java.util.List;

public interface BandService {

	BandModel save(BandModel bandModel) throws DuplicateEntityException;

	List<BandModel> findAll();

	BandModel findOne(long id) throws EntityNotFoundException;

	BandModel update(BandModel bandModel, long id);

	void delete(long id) throws Throwable;

	List<BandModel> findFive();
}

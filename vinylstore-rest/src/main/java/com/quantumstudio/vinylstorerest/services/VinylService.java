package com.quantumstudio.vinylstorerest.services;

import com.quantumstudio.vinylstorerest.components.DiscSize;
import com.quantumstudio.vinylstorerest.entities.Vinyl;
import com.quantumstudio.vinylstorerest.exceptions.DuplicateEntityException;
import com.quantumstudio.vinylstorerest.exceptions.EntityNotFoundException;
import com.quantumstudio.vinylstorerest.models.VinylModel;

import java.util.List;

public interface VinylService {

	VinylModel save(VinylModel vinylModel) throws DuplicateEntityException;

	List<VinylModel> findAll();

	VinylModel findOne(long id) throws EntityNotFoundException;

	VinylModel update(VinylModel vinylModel, long id);

	void delete(long id) throws Throwable;

	List<VinylModel> findFive();

	List<VinylModel> findBySize(DiscSize discSize);

}

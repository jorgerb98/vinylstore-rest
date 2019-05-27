package com.quantumstudio.vinylstorerest.services.impl;

import com.quantumstudio.vinylstorerest.components.DiscSize;
import com.quantumstudio.vinylstorerest.entities.Band;
import com.quantumstudio.vinylstorerest.entities.Vinyl;
import com.quantumstudio.vinylstorerest.exceptions.DuplicateEntityException;
import com.quantumstudio.vinylstorerest.exceptions.EntityNotFoundException;
import com.quantumstudio.vinylstorerest.models.VinylModel;
import com.quantumstudio.vinylstorerest.repositories.VinylRepository;
import com.quantumstudio.vinylstorerest.services.VinylService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VinylServiceImpl implements VinylService {

	private final VinylRepository vinylRepository;

	public VinylServiceImpl(VinylRepository vinylRepository) {
		this.vinylRepository = vinylRepository;
	}

	@Override
	public VinylModel save(VinylModel vinylModel) throws DuplicateEntityException {
		Optional<Vinyl> vinylOptional = vinylRepository.findById(vinylModel.getId());

		if (vinylOptional.isPresent()) {
			throw new DuplicateEntityException();
		}

		Vinyl vinyl = new Vinyl();
		vinyl.setName(vinylModel.getName());
		vinyl.setBand(vinylModel.getBand());
		vinyl.setPurchaseSet(vinylModel.getPurchaseSet());
		vinyl.setPublicationDate(vinylModel.getPublicationDate());
		vinyl.setSize(vinylModel.getSize());
		return VinylModel.from(vinylRepository.save(vinyl));

	}

	@Override
	public List<VinylModel> findAll() {
		return vinylRepository.findAll()
								  .stream()
								  .map(VinylModel::from)
								  .collect(Collectors.toList());
	}

	@Override
	public VinylModel findOne(long id) throws EntityNotFoundException {
		return vinylRepository.findById(id)
								  .map(VinylModel::from)
								  .orElseThrow(EntityNotFoundException::new);

	}

	@Override
	public VinylModel update(VinylModel vinylModel, long id) {
		Vinyl vinyl = new Vinyl();
		vinyl.setName(vinylModel.getName());
		vinyl.setBand(vinylModel.getBand());
		vinyl.setPurchaseSet(vinylModel.getPurchaseSet());
		vinyl.setPublicationDate(vinylModel.getPublicationDate());
		vinyl.setSize(vinylModel.getSize());
		return VinylModel.from(vinylRepository.save(vinyl));
	}

	@Override
	public void delete(long id) throws Throwable {
		Optional<Vinyl> optional = vinylRepository.findById(id);

		if (optional.isPresent()){
			vinylRepository.delete(optional.get());
		}else throw new EntityNotFoundException();

	}

	@Override
	public List<VinylModel> findFive() {
		Comparator<Vinyl> c = (v1, v2)-> v1.getPurchaseSet().size()>v2.getPurchaseSet().size()?1:
										 v1.getPurchaseSet().size()<v2.getPurchaseSet().size()?-1:0;
		return vinylRepository.findAll().stream().sorted(c).map(VinylModel::from).limit(5).collect(Collectors.toList());
	}

	@Override
	public List<VinylModel> findBySize(DiscSize discSize) {
		return vinylRepository.findAll()
							  .stream()
							  .filter(vinyl -> vinyl.getSize().equals(discSize))
							  .map(VinylModel::from)
							  .collect(Collectors.toList());
	}
}

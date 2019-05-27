package com.quantumstudio.vinylstorerest.services.impl;

import com.quantumstudio.vinylstorerest.entities.Client;
import com.quantumstudio.vinylstorerest.entities.Band;
import com.quantumstudio.vinylstorerest.entities.Vinyl;
import com.quantumstudio.vinylstorerest.exceptions.DuplicateEntityException;
import com.quantumstudio.vinylstorerest.exceptions.EntityNotFoundException;
import com.quantumstudio.vinylstorerest.models.ClientModel;
import com.quantumstudio.vinylstorerest.models.BandModel;
import com.quantumstudio.vinylstorerest.models.VinylModel;
import com.quantumstudio.vinylstorerest.repositories.ClientRepository;
import com.quantumstudio.vinylstorerest.repositories.BandRepository;
import com.quantumstudio.vinylstorerest.services.ClientService;
import com.quantumstudio.vinylstorerest.services.BandService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BandServiceImpl implements BandService {

	private final BandRepository bandRepository;

	public BandServiceImpl(BandRepository bandRepository) {
		this.bandRepository = bandRepository;
	}

	@Override
	public BandModel save(BandModel bandModel) throws DuplicateEntityException {
		Optional<Band> bandOptional = bandRepository.findById(bandModel.getId());

		if (bandOptional.isPresent()) {
			throw new DuplicateEntityException();
		}

		Band band = new Band();
		band.setName(bandModel.getName());
		band.setNumberOfMembers(bandModel.getNumberOfMembers());
		band.setVinylSet(bandModel.getVinylSet());
		return BandModel.from(bandRepository.save(band));

	}

	@Override
	public List<BandModel> findAll() {
		return bandRepository.findAll()
								  .stream()
								  .map(BandModel::from)
								  .collect(Collectors.toList());
	}

	@Override
	public BandModel findOne(long id) throws EntityNotFoundException {
		return bandRepository.findById(id)
								  .map(BandModel::from)
								  .orElseThrow(EntityNotFoundException::new);

	}

	@Override
	public BandModel update(BandModel bandModel, long id) {
		Band band = new Band();
		band.setName(bandModel.getName());
		band.setNumberOfMembers(bandModel.getNumberOfMembers());
		return BandModel.from(bandRepository.save(band));
	}

	@Override
	public void delete(long id) throws Throwable {
		Optional<Band> optional = bandRepository.findById(id);

		if (optional.isPresent()){
			bandRepository.delete(optional.get());
		}else throw new EntityNotFoundException();

	}

	@Override
	public List<BandModel> findFive() {
		Comparator<Band> c = (b1,b2)->(b1.getVinylSet().stream().filter(vinyl -> vinyl.getPurchaseSet().size()>0)).count()>(b2.getVinylSet().stream().filter(vinyl -> vinyl.getPurchaseSet().size()>0)).count()?1:
										   (b1.getVinylSet().stream().filter(vinyl -> vinyl.getPurchaseSet().size()>0)).count()<(b2.getVinylSet().stream().filter(vinyl -> vinyl.getPurchaseSet().size()>0)).count()?-1:0;

		return bandRepository.findAll()
							 .stream()
							 .sorted(c)
							 .map(BandModel::from)
							 .limit(5)
							 .collect(Collectors.toList());

	}
}

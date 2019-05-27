package com.quantumstudio.vinylstorerest.controllers;

import com.quantumstudio.vinylstorerest.exceptions.DuplicateEntityException;
import com.quantumstudio.vinylstorerest.exceptions.EntityNotFoundException;
import com.quantumstudio.vinylstorerest.models.BandModel;
import com.quantumstudio.vinylstorerest.services.BandService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BandController {

	private final BandService bandService;

	public BandController(BandService bandService) {
		this.bandService = bandService;
	}

	@GetMapping("/band")
	public List<BandModel> findAll(){
		return bandService.findAll();
	}
	@GetMapping("/band/{id}")
	public BandModel findOne(@PathVariable long id) throws EntityNotFoundException {
		return bandService.findOne(id);
	}

	@PostMapping("/band")
	public BandModel save(@Valid @RequestBody BandModel bandModel) throws DuplicateEntityException {
		return bandService.save(bandModel);
	}
	@PutMapping("/band/{id}")
	public BandModel update(@Valid @RequestBody BandModel bandModel,@PathVariable long id){
		return bandService.update(bandModel,id);
	}
	@DeleteMapping("/band/{id}")
	public void delete(@Valid @PathVariable int id) throws Throwable {
		bandService.delete(id);
	}

	@GetMapping("/bandFive/")
	public List<BandModel> findFive(){
		return bandService.findFive();
	}

	@GetMapping("/bands")
	public int findNumberOfBands()  {
		return bandService.findAll().size();
	}

}

package com.quantumstudio.vinylstorerest.controllers;

import com.quantumstudio.vinylstorerest.components.DiscSize;
import com.quantumstudio.vinylstorerest.exceptions.DuplicateEntityException;
import com.quantumstudio.vinylstorerest.exceptions.EntityNotFoundException;
import com.quantumstudio.vinylstorerest.models.BandModel;
import com.quantumstudio.vinylstorerest.models.VinylModel;
import com.quantumstudio.vinylstorerest.services.VinylService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VinylController {

	private final VinylService vinylService;

	public VinylController(VinylService vinylService) {
		this.vinylService = vinylService;
	}

	@GetMapping("/vinyl")
	public List<VinylModel> findAll(){
		return (vinylService.findAll());
	}
	@GetMapping("/vinyl/{id}")
	public VinylModel findOne(@PathVariable long id) throws EntityNotFoundException {
		return vinylService.findOne(id);
	}

	@PostMapping("/vinyl")
	public VinylModel save(@Valid @RequestBody VinylModel vinylModel) throws DuplicateEntityException {
		return (vinylService.save(vinylModel));
	}
	@PutMapping("/vinyl/{id}")
	public VinylModel update(@Valid @RequestBody VinylModel vinylModel,@PathVariable long id){
		return (vinylService.update(vinylModel,id));
	}
	@DeleteMapping("/vinyl/{id}")
	public void delete(@Valid @PathVariable int id) throws Throwable {
		vinylService.delete(id);
	}
	@GetMapping("/vinylFive/")
	public List<VinylModel> findFive(){
		return vinylService.findFive();
	}
	@GetMapping("/vinyl/{discSize}")
	public int findBySize(@PathVariable DiscSize discSize)  {
		return vinylService.findBySize(discSize).size();
	}

	@GetMapping("/vinyls")
	public int findNumberOfVinyls()  {
		return vinylService.findAll().size();
	}




}

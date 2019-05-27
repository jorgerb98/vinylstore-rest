package com.quantumstudio.vinylstorerest.models;

import com.quantumstudio.vinylstorerest.entities.Band;
import com.quantumstudio.vinylstorerest.entities.Vinyl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;


public class BandModel {


	private long id;

	@NotNull
	private String name;

	@NotNull
	private int numberOfMembers;

	private Set<Vinyl> vinylSet;

	public static BandModel from(Band band){
		BandModel bandModel = new BandModel();
		bandModel.setNumberOfMembers(band.getNumberOfMembers());
		bandModel.setId(band.getId());
		bandModel.setName(band.getName());
		bandModel.setVinylSet(band.getVinylSet());
		return  bandModel;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public Set<Vinyl> getVinylSet() {
		return vinylSet;
	}

	public void setVinylSet(Set<Vinyl> vinylSet) {
		this.vinylSet = vinylSet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

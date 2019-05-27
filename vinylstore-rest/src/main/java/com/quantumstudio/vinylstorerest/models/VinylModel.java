package com.quantumstudio.vinylstorerest.models;

import com.quantumstudio.vinylstorerest.components.DiscSize;
import com.quantumstudio.vinylstorerest.entities.Client;
import com.quantumstudio.vinylstorerest.entities.Band;
import com.quantumstudio.vinylstorerest.entities.Purchase;
import com.quantumstudio.vinylstorerest.entities.Vinyl;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class VinylModel {


	private long id;


	@NotNull
	private String name;

	@NotNull
	private Band band;

	@NotNull
	private String publicationDate;

	@NotNull
	private DiscSize size;

	private Set<Purchase> purchaseSet;

	public static VinylModel from(Vinyl vinyl){
		VinylModel vinylModel = new VinylModel();
		vinylModel.setPurchaseSet(vinyl.getPurchaseSet());
		vinylModel.setId(vinyl.getId());
		vinylModel.setName(vinyl.getName());
		vinylModel.setBand(vinyl.getBand());
		vinylModel.setPublicationDate(vinyl.getPublicationDate());
		vinylModel.setSize(vinyl.getSize());
		return  vinylModel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	public Set<Purchase> getPurchaseSet() {
		return purchaseSet;
	}

	public void setPurchaseSet(Set<Purchase> purchaseSet) {
		this.purchaseSet = purchaseSet;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public DiscSize getSize() {
		return size;
	}

	public void setSize(DiscSize size) {
		this.size = size;
	}
}

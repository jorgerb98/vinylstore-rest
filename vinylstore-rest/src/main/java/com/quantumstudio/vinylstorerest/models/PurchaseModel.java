package com.quantumstudio.vinylstorerest.models;

import com.quantumstudio.vinylstorerest.entities.Client;
import com.quantumstudio.vinylstorerest.entities.Purchase;
import com.quantumstudio.vinylstorerest.entities.Vinyl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class PurchaseModel {


	private long id;

	@NotNull
	private String date;

	@NotNull
	private int units;

	private Client client;

	@NotNull
	private Set<Vinyl> vinylSet;


	public static PurchaseModel from(Purchase purchase){
		PurchaseModel purchaseModel = new PurchaseModel();
		purchaseModel.setDate(purchase.getDate());
		purchaseModel.setId(purchase.getId());
		purchaseModel.setUnits(purchase.getUnits());
		purchaseModel.setClient(purchase.getClient());
		purchaseModel.setVinylSet(purchase.getVinylSet());
		return  purchaseModel;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Vinyl> getVinylSet() {
		return vinylSet;
	}

	public void setVinylSet(Set<Vinyl> vinylSet) {
		this.vinylSet = vinylSet;
	}
}

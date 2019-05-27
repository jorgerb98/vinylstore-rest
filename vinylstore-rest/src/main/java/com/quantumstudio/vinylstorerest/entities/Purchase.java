package com.quantumstudio.vinylstorerest.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Purchase {
	@Id
	@NotNull
	@GeneratedValue
	private long id;

	@NotNull
	private String date;

	@NotNull
	@Min(0)
	private int units;

	@ManyToOne
	private Client client;

	@ManyToMany(mappedBy = "purchaseSet")
	private Set<Vinyl> vinylSet;

	public Purchase() {
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

	public Set getVinylSet() {
		return vinylSet;
	}

	public void setVinylSet(Set vinylSet) {
		this.vinylSet = vinylSet;
	}
}

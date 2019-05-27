package com.quantumstudio.vinylstorerest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Band {


	@NotNull
	@Id
	@GeneratedValue
	private long id;
	@NotNull
	private String name;

	@NotNull
	private int numberOfMembers;

	@OneToMany
	private Set<Vinyl> vinylSet;

	public Band(@NotNull String name, @NotNull int numberOfMembers) {
		this.name = name;
		this.numberOfMembers = numberOfMembers;
	}

	public Band() {
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

package com.quantumstudio.vinylstorerest.entities;

import com.quantumstudio.vinylstorerest.components.DiscSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class Vinyl {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 3)
    @NotNull
    private String name;

    @NotNull
    private String publicationDate;

    @NotNull
    private DiscSize size;

    @NotNull
    @ManyToOne
    private Band band;

    @NotNull
    @ManyToMany
    private Set<Purchase> purchaseSet;


    public Vinyl() {
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

}

package com.quantumstudio.vinylstorerest.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 3)
    @NotNull
    private String name;

    @Size(min = 6)
    @NotNull
    private String password;

    @OneToMany
    private Set<Purchase> purchaseSet;

    public Client() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Purchase> getPurchaseSet() {
        return purchaseSet;
    }

    public void setPurchaseSet(Set<Purchase> purchaseSet) {
        this.purchaseSet = purchaseSet;
    }
}

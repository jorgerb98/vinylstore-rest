package com.quantumstudio.vinylstorerest.models;

import com.quantumstudio.vinylstorerest.entities.Client;
import com.quantumstudio.vinylstorerest.entities.Band;
import com.quantumstudio.vinylstorerest.entities.Purchase;
import com.quantumstudio.vinylstorerest.entities.Vinyl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class ClientModel {


    private long id;

    @NotNull
    private String name;


    @NotNull
    private String password;


    private Set<Purchase> purchaseSet;

    public static ClientModel from(Client client){
        ClientModel clientModel = new ClientModel();
        clientModel.setPassword(client.getPassword());
        clientModel.setId(client.getId());
        clientModel.setName(client.getName());
        clientModel.setPurchaseSet(client.getPurchaseSet());
        return  clientModel;
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

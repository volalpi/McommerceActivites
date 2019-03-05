package com.mexpedition.microserviceexpedition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expedition {
    @Id
    @GeneratedValue
    private int id;

    private int idCommande;

    private int etat;


    public Expedition() {
    }

    public Expedition(int idCommande, int etat) {
        this.idCommande = idCommande;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public int getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        return "Expedition{" +
                "id=" + id +
                ", idCommande=" + idCommande +
                ", etat=" + etat +
                '}';
    }
}

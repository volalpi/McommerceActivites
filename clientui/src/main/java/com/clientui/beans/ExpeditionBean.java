package com.clientui.beans;

public class ExpeditionBean {

    private int id;

    private int idCommande;

    private int etat;

    private String etatToString;


    public ExpeditionBean() {
    }



    public ExpeditionBean(int idCommande, int etat) {
        this.idCommande = idCommande;
        this.etat = etat;
    }

    public String getEtatToString() {
        if (this.etat == 0) {
            this.etatToString = "En préparation";
        } else if(this.etat == 1) {
            this.etatToString = "Expédiée";
        } else if(this.etat == 2) {
            this.etatToString = "Livrée";
        }
        return etatToString;
    }

    public void setEtatToString(String etatToString) {
        this.etatToString = etatToString;
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

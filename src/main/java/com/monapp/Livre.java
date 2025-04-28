package com.monapp;

public class Livre {
    private String titre;
    private String auteur;
    protected String id;
    private boolean disponible;

    public Livre(String titre, String auteur, String id, boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.id = id;
        this.disponible = disponible;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getId() {
        return id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void emprunter() {
        this.disponible = false;
    }

    public void retourner() {
        this.disponible = true;
    }
}

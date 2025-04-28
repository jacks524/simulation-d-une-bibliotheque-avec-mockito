package com.monapp;

public interface BibliothequeDatabase {
    void savebook(Livre livre);

    Livre findLivre(String titre);

}

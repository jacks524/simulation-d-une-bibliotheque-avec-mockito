package com.monapp;

import java.sql.*;

public class Database implements BibliothequeDatabase {
    private Connection connection;

    public Database(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void savebook(Livre livre) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO livres (titre, auteur, id, disponible) VALUES (?, ?, ?, ?)");
            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setString(3, livre.getId());
            stmt.setBoolean(4, livre.isDisponible());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Livre findLivre(String titre) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM livres WHERE titre = ?");
            stmt.setString(1, titre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Livre(
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("id"),
                        rs.getBoolean("disponible"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

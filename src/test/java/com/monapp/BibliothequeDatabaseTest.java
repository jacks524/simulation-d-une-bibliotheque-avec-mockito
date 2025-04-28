package com.monapp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.Assert.*;

public class BibliothequeDatabaseTest {
    private Connection connection;
    private Database database;

    @Before
    public void setUp() throws Exception {
        // Connexion à une base H2 en mémoire
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        Statement stmt = connection.createStatement();

        stmt.execute("DROP TABLE IF EXISTS livres");
        // Créer la table
        stmt.execute(
                "CREATE TABLE livres (titre VARCHAR(255), auteur VARCHAR(255), id VARCHAR(255), disponible BOOLEAN)");

        // Instancier la base avec notre vraie implémentation
        database = new Database(connection);
    }

    @Test
    public void testSaveAndFindLivre() {
        Livre livre = new Livre("Harry Potter", "J.K. Rowling", "ISBN1234", true);

        database.savebook(livre);

        Livre found = database.findLivre("Harry Potter");
        assertNotNull(found);
        assertEquals("J.K. Rowling", found.getAuteur());
        assertEquals("ISBN1234", found.getId());
        assertTrue(found.isDisponible());
    }

    @Test
    public void testSavebook_withMockito() {
        BibliothequeDatabase mockDb = Mockito.mock(BibliothequeDatabase.class);
        Livre livre = new Livre("Le Seigneur des Anneaux", "Tolkien", "ISBN5678", true);

        mockDb.savebook(livre);
        Mockito.verify(mockDb).savebook(livre);
    }
}

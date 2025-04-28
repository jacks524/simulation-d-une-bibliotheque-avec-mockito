package com.monapp;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private UserDatabase database;

    @Before
    public void setUp() {
        database = mock(UserDatabase.class);
    }

    /*
     * Dans la partie test on commence par créer un nouvel user
     * puis quand findByName est appelé, il renvoie user
     * ensuite on simule l'action de save
     * on vérifie que save est bien appelé
     * on vérifie que findByName retourne bien l'utilisateur
     */
    @Test
    public void tester_Sauvegarder_FindUser() {
        User user = new Normaluser("NGONGA", "jacquyngonga@gmail.com", "123456789");

        when(database.findByName("NGONGA")).thenReturn(user);

        database.save(user);

        verify(database).save(user);

        User foundUser = database.findByName("NGONGA");
        assertNotNull(foundUser);
        assertEquals("NGONGA", foundUser.getName());
        assertEquals("jacquyngonga@gmail.com", foundUser.getEmail());
        assertEquals("123456789", foundUser.getPhonenumber());
    }
}

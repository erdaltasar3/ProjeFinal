// src/test/java/com/mycompany/proje/PazarlamaCalisanEkleTest.java
package com.mycompany.proje;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.mockito.Mockito.*;

public class PazarlamaCalisanEkleTest {
    private PazarlamaCalisanEkle pazarlamaCalisanEkle;
    private Connection mockConnection;
    private Statement mockStatement;

    @BeforeEach
    void setUp() throws Exception {
        pazarlamaCalisanEkle = new PazarlamaCalisanEkle();
        mockConnection = Mockito.mock(Connection.class);
        mockStatement = Mockito.mock(Statement.class);

        DriverManager.setLoginTimeout(10); // Optional
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(DriverManager.getConnection(anyString(), anyString(), anyString())).thenReturn(mockConnection);
    }

    @Test
    void testCalisanEkle() throws Exception {
        pazarlamaCalisanEkle.calisanEkle(1, "Mehmet", "Kaya", 25, 4000);
        verify(mockStatement, times(1)).executeUpdate(anyString());
    }
}


// src/test/java/com/mycompany/proje/UretimCalisanEkleTest.java
package com.mycompany.proje;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.mockito.Mockito.*;

public class UretimCalisanEkleTest {
    private UretimCalisanEkle uretimCalisanEkle;
    private Connection mockConnection;
    private Statement mockStatement;

    @BeforeEach
    void setUp() throws Exception {
        uretimCalisanEkle = new UretimCalisanEkle();
        mockConnection = Mockito.mock(Connection.class);
        mockStatement = Mockito.mock(Statement.class);

        DriverManager.setLoginTimeout(10); // Optional
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(DriverManager.getConnection(anyString(), anyString(), anyString())).thenReturn(mockConnection);
    }

    @Test
    void testCalisanEkle() throws Exception {
        uretimCalisanEkle.calisanEkle(1, "Ayse", "Demir", 28, 4500);
        verify(mockStatement, times(1)).executeUpdate(anyString());
    }
}

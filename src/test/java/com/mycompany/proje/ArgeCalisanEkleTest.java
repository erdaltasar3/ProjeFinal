
package com.mycompany.proje;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.mockito.Mockito.*;

public class ArgeCalisanEkleTest {
    private ArgeCalisanEkle argeCalisanEkle;
    private Connection mockConnection;
    private Statement mockStatement;

    @BeforeEach
    void setUp() throws Exception {
        argeCalisanEkle = new ArgeCalisanEkle();
        mockConnection = Mockito.mock(Connection.class);
        mockStatement = Mockito.mock(Statement.class);

        DriverManager.setLoginTimeout(10); // Optional
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(DriverManager.getConnection(anyString(), anyString(), anyString())).thenReturn(mockConnection);
    }

    @Test
    void testCalisanEkle() throws Exception {
        argeCalisanEkle.calisanEkle(1, "Ahmet", "Yilmaz", 30, 5000);
        verify(mockStatement, times(1)).executeUpdate(anyString());
    }
}


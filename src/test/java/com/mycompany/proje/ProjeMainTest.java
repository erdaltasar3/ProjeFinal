// src/test/java/com/mycompany/proje/ProjeMainTest.java
package com.mycompany.proje;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

public class ProjeMainTest {

    @Test
    void testMain() throws Exception {
        NesneProje nesneProjeMock = Mockito.mock(NesneProje.class);
        ProjeMain main = new ProjeMain();

        String input = "1\n1\nJohn\nDoe\n30\n5000\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ProjeMain.main(new String[]{});

        verify(nesneProjeMock, times(1)).calisanEkle(anyInt(), anyString(), anyString(), anyInt(), anyInt());
    }
}


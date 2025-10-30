package org.formacion.procesosservicios.service;

import org.formacion.procesos.services.ComandoServicesLS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class comandoServiceLSTest {

    ComandoServicesLS comandoServicesLS;

    @BeforeEach
    void before(){
        comandoServicesLS = new ComandoServicesLS();
        comandoServicesLS.setComando("ls");
    }

    @Test
    void validarTest(){
        String[] arrayComando = {"ls", "-i"};
        boolean estado = comandoServicesLS.validaComando(arrayComando);
        assertTrue(estado);
    }

    @Test
    void validarFalseTest(){
        String[] arrayComando = {"ls", "-laala"};
        boolean estado = comandoServicesLS.validaComando(arrayComando);
        assertFalse(estado);
    }
}

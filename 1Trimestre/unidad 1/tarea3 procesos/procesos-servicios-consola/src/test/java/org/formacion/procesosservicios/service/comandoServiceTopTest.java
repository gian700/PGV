package org.formacion.procesosservicios.service;

import org.formacion.procesos.services.ComandoServicesTop;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class comandoServiceTopTest {

    ComandoServicesTop comandoServicesTop;

    @BeforeEach
    void before(){
        comandoServicesTop = new ComandoServicesTop();
        comandoServicesTop.setComando("top");
    }

    @Test
    void validarTest(){
        String[] arrayComando = {"top", "-bn1"};
        boolean estado = comandoServicesTop.validaComando(arrayComando);
        assertTrue(estado);
    }

    @Test
    void validarFalseTest(){
        String[] arrayComando = {"top", "-laala"};
        boolean estado = comandoServicesTop.validaComando(arrayComando);
        assertFalse(estado);
    }
}

package org.formacion.procesosservicios.repository;

import org.formacion.procesos.repositories.FileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileRepositoryTest {
    private static final String NO_SE_HA_OBTENIDO_EL_RESULTADO_ESPERADO = "No se ha obtenido el resultado esperado";
    static FileRepository fileRepository;

    @BeforeAll
    static void BeforeAll(){
        fileRepository = new FileRepository();
    }

    @Test
    void addContenidoTest(){
        boolean resultado = fileRepository.add("pedro");
        Assertions.assertTrue(resultado, NO_SE_HA_OBTENIDO_EL_RESULTADO_ESPERADO);
    }
}

package org.formacion.procesos.controllers;

import java.util.Scanner;

import org.formacion.procesos.services.ComandoServicePs;
import org.formacion.procesos.services.ComandoServicesLS;
import org.formacion.procesos.services.ComandoServicesLsof;
import org.formacion.procesos.services.ComandoServicesTop;
import org.formacion.procesos.services.abstractas.ComandoServicesAbstractas;
import org.springframework.stereotype.Service;

@Service
public class RunnerController {

    private final ComandoServicesLS comandoServicesLS;

    
    ComandoServicesAbstractas comandoService;

    RunnerController(ComandoServicesLS comandoServicesLS) {
        this.comandoServicesLS = comandoServicesLS;
    }

    public void menuConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Lanzador de Procesos (CLI) Linux/Windows ===\n" +
                "Comandos:\n" +
                "  run PING host=8.8.8.8 count=4 timeoutMs=15000\n" +
                "  run LIST_DIR path=.\n" +
                "  run HASH_SHA256 file=README.md\n" +
                "  help | os | exit\n");
          String linea = scanner.nextLine();
          String comienza = (linea.split(" "))[0];
          switch (comienza.toUpperCase()) {
            case "PS" -> comandoService = new ComandoServicePs();
            case "LS" -> comandoService = new ComandoServicesLS();
            case "TOP" -> comandoService = new ComandoServicesTop(); 
            default -> comandoService = new ComandoServicesLsof();    
          }
          comandoService.procesarComando(linea);
    }

    private void helpConsola() {
        System.out.println(
                "Ejemplos\n" +
                        "run PING host=8.8.8.8 count=4\n" +
                        "run LIST_DIR path=.\n" +
                        "run HASH_SHA256 file=README.md timeoutMs=5000\n");
    }

}

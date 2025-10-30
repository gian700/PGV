package org.formacion.procesos.services.abstractas;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.formacion.procesos.domain.ProcessType;
import org.formacion.procesos.repositories.FileRepository;
import org.formacion.procesos.repositories.interfaces.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class ComandoServicesAbstractas {
    private String comando;
    private List<String> parametros;
    private ProcessType tipo;
    private String expresionRegular;

    @Autowired
    CrudInterface fileRepository;

    public String getComando() {
        return comando;
    }

    public List<String> getParametros() {
        return parametros;
    }

    public ProcessType getTipo() {
        return tipo;
    }

    public String getTipoString() {
        if (tipo == null) {
            return null;
        }
        return tipo.toString();
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public void setParametros(List<String> parametros) {
        this.parametros = parametros;
    }

    public void setTipo(ProcessType tipo) {
        this.tipo = tipo;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public void procesarComando(String linea){
        String[] arrayComando = linea.split(" ");
        setComando(arrayComando[0]);
        System.out.println("comando: " +getComando());
        if (!validaComando(arrayComando)) {
            System.out.println("El comando es tetraplejico");
            return;
        }
        Process proceso1;
        try{
            FileRepository fileRepository = new FileRepository();
            proceso1 = new ProcessBuilder("sh", "-c", linea + " > " + fileRepository.getPath())
                                .start();
                        proceso1.waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean ejecutarProceso(Process proceso){
        try {
            proceso.waitFor();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean validaComando(String[] arrayParametro){
        if (!this.getComando().toUpperCase().equals(getTipoString())){
            return false;
        }
        String parametro = arrayParametro[1];
        Pattern patern = Pattern.compile(expresionRegular);
        Matcher matcher = patern.matcher(parametro);
        return matcher.find();
    }
    
}

package org.formacion.procesos.repositories;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.formacion.procesos.repositories.interfaces.CrudInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository implements CrudInterface{
    private static Logger logger = LoggerFactory.getLogger(FileRepository.class);
    String fileName;
    Path path;
    
    public FileRepository(){
        if (fileName == null) {
            fileName = "mis_procesos.txt";
        }
        path = Paths.get("src/main/resources/" + fileName);
    }

    public Path getPath() {
        return path;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    @Override
    public boolean add(String text) {
        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (Exception e) {
            logger.error("se ha producido un error", e);
        }
        return false;
    }

}

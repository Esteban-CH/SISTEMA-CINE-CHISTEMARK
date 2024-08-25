package com.example.demo.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class Utilitarios {
	
	public static String Imagen(MultipartFile file) {
        try {
            Path pathDire = Paths.get("src/main/resources/static/img/");
            if (!Files.exists(pathDire)) {
                Files.createDirectories(pathDire);
            }
            
            byte[] bytes = file.getBytes();
            String nombreArchivo = file.getOriginalFilename();
            Path path = Paths.get("src/main/resources/static/img/" + nombreArchivo);
            
            Files.write(path, bytes);
            return nombreArchivo;
            
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void eliminarImagen(String nombreArchivo) {
        try {
            Path path = Paths.get("src/main/resources/static/img/" + nombreArchivo);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

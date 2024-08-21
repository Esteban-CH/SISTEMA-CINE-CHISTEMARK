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
			if(!Files.exists(pathDire)) {
				Files.createDirectories(pathDire);
			}
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get("src/main/resources/static/img/" + 
			file.getOriginalFilename());
			
			Files.write(path, bytes);
			return file.getOriginalFilename();
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

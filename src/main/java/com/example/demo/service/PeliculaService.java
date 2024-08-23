package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.PeliculaEntity;

public interface PeliculaService {
	
	List<PeliculaEntity> listarPeliculas();
    Optional<PeliculaEntity> obtenerPeliculaPorId(Long id);
    PeliculaEntity guardarPelicula(PeliculaEntity pelicula, MultipartFile file);
    PeliculaEntity actualizarPelicula(PeliculaEntity pelicula, MultipartFile file);
    void eliminarPelicula(Long id);
    List<PeliculaEntity> buscarPorTitulo(String titulo);
    List<PeliculaEntity> buscarPorDirector(String director);
    List<PeliculaEntity> buscarPorGeneroId(Long generoId);
}

package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.PeliculaEntity;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.service.PeliculaService;
import com.example.demo.utils.Utilitarios;

@Service
public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Override
	public List<PeliculaEntity> listarPeliculas() {
		return peliculaRepository.findAll();
	}

	@Override
	public Optional<PeliculaEntity> obtenerPeliculaPorId(Long id) {
		return peliculaRepository.findById(id);
	}

	@Override
	public PeliculaEntity guardarPelicula(PeliculaEntity pelicula, MultipartFile file) {
		if (file != null && !file.isEmpty()) {
            String nombreImagen = Utilitarios.Imagen(file);
            pelicula.setUrlImagen(nombreImagen);
        }
		return peliculaRepository.save(pelicula);
	}

	@Override
	public PeliculaEntity actualizarPelicula(PeliculaEntity pelicula, MultipartFile file) {
		PeliculaEntity peliculaExistente = peliculaRepository.findById(pelicula.getPeliculaId()).get();
		
		// Si se proporciona una nueva imagen, maneja la antigua
        if (file != null && !file.isEmpty()) {
            // Elimina la imagen antigua si existe
            if (peliculaExistente.getUrlImagen() != null) {
                Utilitarios.eliminarImagen(peliculaExistente.getUrlImagen());
            }
            // Guarda la nueva imagen
            String nombreImagen = Utilitarios.Imagen(file);
            pelicula.setUrlImagen(nombreImagen); // Actualiza el nombre de la imagen en la BD
        } else {
            // Mantiene la imagen existente si no se proporciona una nueva
            pelicula.setUrlImagen(pelicula.getUrlImagen());
        }
		
		return peliculaRepository.save(pelicula);
	}

	@Override
	public void eliminarPelicula(Long id) {
		peliculaRepository.deleteById(id);
		
	}

	@Override
	public List<PeliculaEntity> buscarPorTitulo(String titulo) {
		return peliculaRepository.findByTituloContaining(titulo);
	}

	@Override
	public List<PeliculaEntity> buscarPorDirector(String director) {
		return peliculaRepository.findByDirector(director);
	}

	@Override
	public List<PeliculaEntity> buscarPorGeneroId(Long generoId) {
		return peliculaRepository.findByGenero_GeneroId(generoId);
	}

}

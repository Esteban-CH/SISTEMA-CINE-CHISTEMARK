package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.SalaEntity;

public interface SalaService {

	List<SalaEntity> listarSalas();
	Optional<SalaEntity> obtenerSalaPorId(Long id);
	SalaEntity crearSala(SalaEntity sala);
	SalaEntity actualizarSala(SalaEntity sala);
	void eliminarSala(Long id);
}

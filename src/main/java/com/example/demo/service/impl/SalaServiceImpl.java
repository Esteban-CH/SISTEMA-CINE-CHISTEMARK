package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SalaEntity;
import com.example.demo.repository.SalaRepository;
import com.example.demo.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService{

	@Autowired
	private SalaRepository salaRepository;
	
	@Override
	public List<SalaEntity> listarSalas() {
		return salaRepository.findAll();
	}

	@Override
	public Optional<SalaEntity> obtenerSalaPorID(Long id) {
		return salaRepository.findById(id);
	}

	@Override
	public SalaEntity crearSala(SalaEntity sala) {
		return salaRepository.save(sala);
	}

	@Override
	public SalaEntity actualizarSala(SalaEntity sala) {
		return salaRepository.save(sala);
	}

	@Override
	public void eliminarSala(Long id) {
		salaRepository.deleteById(id);
	}

}

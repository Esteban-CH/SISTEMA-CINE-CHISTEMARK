package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AsientoEntity;
import com.example.demo.repository.AsientoRepository;
import com.example.demo.service.AsientoService;

@Service
public class AsientoServiceImpl implements AsientoService{

	@Autowired
	private AsientoRepository asientoRepository;
	
	@Override
	public List<AsientoEntity> listarAsientos() {
		return asientoRepository.findAll();
	}

	@Override
	public AsientoEntity obtenerAsientoPorId(Long id) {
		return asientoRepository.findById(id).get();
	}

	@Override
	public AsientoEntity crearAsiento(AsientoEntity asiento) {
		return asientoRepository.save(asiento);
	}

	@Override
	public AsientoEntity actualizarAsiento(AsientoEntity asiento) {
		return asientoRepository.save(asiento);
	}

	@Override
	public void eliminarAsiento(Long id) {
		asientoRepository.deleteById(id);
	}

}

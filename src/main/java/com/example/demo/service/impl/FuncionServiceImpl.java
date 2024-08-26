package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FuncionEntity;
import com.example.demo.repository.FuncionRepository;
import com.example.demo.service.FuncionService;

@Service
public class FuncionServiceImpl implements FuncionService{

	@Autowired
	private FuncionRepository funcionRepository;
	
	@Override
	public List<FuncionEntity> listarFunciones() {
		return funcionRepository.findAll();
	}

	@Override
	public FuncionEntity obtenerFuncionPorId(Long id) {
		return funcionRepository.findById(id).get();
	}

	@Override
	public FuncionEntity crearFuncion(FuncionEntity funcion) {
		return funcionRepository.save(funcion);
	}

	@Override
	public FuncionEntity actualizarFuncion(FuncionEntity funcion) {
		return funcionRepository.save(funcion);
	}

	@Override
	public void eliminarFuncion(Long id) {
		funcionRepository.deleteById(id);
	}

}

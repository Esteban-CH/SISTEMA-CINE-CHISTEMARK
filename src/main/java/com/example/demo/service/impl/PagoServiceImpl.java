package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PagoEntity;
import com.example.demo.repository.PagoRepository;
import com.example.demo.service.PagoService;

@Service
public class PagoServiceImpl implements PagoService{

	@Autowired
	private PagoRepository pagoRepository;
	
	@Override
	public List<PagoEntity> listarPagos() {
		return pagoRepository.findAll();
	}

	@Override
	public PagoEntity obtenerPagoPorId(Long id) {
		return pagoRepository.findById(id).get();
	}

	@Override
	public PagoEntity crearPago(PagoEntity pago) {
		return pagoRepository.save(pago);
	}

	@Override
	public PagoEntity actualizarPago(PagoEntity pago) {
		return pagoRepository.save(pago);
	}

	@Override
	public void eliminarPago(Long id) {
		pagoRepository.deleteById(id);
	}

}

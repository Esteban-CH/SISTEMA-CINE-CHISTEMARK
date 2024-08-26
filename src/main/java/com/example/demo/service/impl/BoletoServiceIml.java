package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BoletoEntity;
import com.example.demo.repository.BoletoRepository;
import com.example.demo.service.BoletoService;

@Service
public class BoletoServiceIml implements BoletoService{

	@Autowired
	private BoletoRepository boletoRepository;
	
	@Override
	public List<BoletoEntity> listarBoletos() {
		return boletoRepository.findAll();
	}

	@Override
	public BoletoEntity obtenerBoletoPorId(Long id) {
		return boletoRepository.findById(id).get();
	}

	@Override
	public BoletoEntity crearBoleto(BoletoEntity boleto) {
		return boletoRepository.save(boleto);
	}

	@Override
	public BoletoEntity actualizarBoleto(BoletoEntity boleto) {
		return boletoRepository.save(boleto);
	}

	@Override
	public void eliminarBoleto(Long id) {
		boletoRepository.deleteById(id);
	}

}

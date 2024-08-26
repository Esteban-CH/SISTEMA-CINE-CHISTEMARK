package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BoletoEntity;

public interface BoletoService {
	
	List<BoletoEntity> listarBoletos();
    BoletoEntity obtenerBoletoPorId(Long id);
    BoletoEntity crearBoleto(BoletoEntity boleto);
    BoletoEntity actualizarBoleto(BoletoEntity boleto);
    void eliminarBoleto(Long id);
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PagoEntity;

public interface PagoService {
	
	List<PagoEntity> listarPagos();
    PagoEntity obtenerPagoPorId(Long id);
    PagoEntity crearPago(PagoEntity pago);
    PagoEntity actualizarPago(PagoEntity pago);
    void eliminarPago(Long id);
}	

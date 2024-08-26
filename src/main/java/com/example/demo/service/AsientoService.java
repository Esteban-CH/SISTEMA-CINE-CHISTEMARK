package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AsientoEntity;

public interface AsientoService {
	
	List<AsientoEntity> listarAsientos();
    AsientoEntity obtenerAsientoPorId(Long id);
    AsientoEntity crearAsiento(AsientoEntity asiento);
    AsientoEntity actualizarAsiento(AsientoEntity asiento);
    void eliminarAsiento(Long id);
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.FuncionEntity;

public interface FuncionService {
	
	List<FuncionEntity> listarFunciones();
    FuncionEntity obtenerFuncionPorId(Long id);
    FuncionEntity crearFuncion(FuncionEntity funcion);
    FuncionEntity actualizarFuncion(FuncionEntity funcion);
    void eliminarFuncion(Long id);
}

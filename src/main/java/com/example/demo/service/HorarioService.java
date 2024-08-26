package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.HorarioEntity;

public interface HorarioService {

	List<HorarioEntity> listarHorarios();
    HorarioEntity obtenerHorarioPorId(Long id);
    HorarioEntity crearHorario(HorarioEntity horario);
    HorarioEntity actualizarHorario(HorarioEntity horario);
    void eliminarHorario(Long id);
}

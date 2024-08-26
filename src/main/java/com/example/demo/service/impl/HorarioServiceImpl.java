package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HorarioEntity;
import com.example.demo.repository.HorarioRepository;
import com.example.demo.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService{

	@Autowired
	private HorarioRepository horarioRepository;
	
	@Override
	public List<HorarioEntity> listarHorarios() {
		return horarioRepository.findAll(); 
	}

	@Override
	public HorarioEntity obtenerHorarioPorId(Long id) {
		return horarioRepository.findById(id).get();
	}

	@Override
	public HorarioEntity crearHorario(HorarioEntity horario) {
		return horarioRepository.save(horario);
	}

	@Override
	public HorarioEntity actualizarHorario(HorarioEntity horario) {
		return horarioRepository.save(horario);
	}

	@Override
	public void eliminarHorario(Long id) {
		horarioRepository.deleteById(id);
	}

}

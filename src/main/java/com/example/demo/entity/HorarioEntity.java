package com.example.demo.entity;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_horario")
public class HorarioEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long horarioId;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private String diaSemana;
	
	// Relación con la entidad Función
    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL)
    private List<FuncionEntity> funciones;
	
}

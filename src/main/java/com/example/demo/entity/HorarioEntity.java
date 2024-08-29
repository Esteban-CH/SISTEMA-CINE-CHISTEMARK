package com.example.demo.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
    @JoinColumn(name = "funcion_id", nullable = false)
    private FuncionEntity funcion;
	
}

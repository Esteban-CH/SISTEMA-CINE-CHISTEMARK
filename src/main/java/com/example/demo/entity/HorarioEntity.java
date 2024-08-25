package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_horario")
public class HorarioEntity {

	private Long horarioId;
	private Date fchaHora;
	
	@ManyToOne
	@JoinColumn(name = "sala_id")
	private SalaEntity sala;
	
	@ManyToOne
	@JoinColumn(name = "pelicula_id")
	private PeliculaEntity pelicula;
}

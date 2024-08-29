package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_funcion")
public class FuncionEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcionId;
	
	@ManyToOne
    @JoinColumn(name = "pelicula_id", nullable = false)
	private PeliculaEntity pelicula;
	
	@ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
	private SalaEntity sala;
	
	// Relación con la entidad Horario (Una función tiene muchos horarios)
    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL)
    private List<HorarioEntity> horarios;
    
	private String estado;
	
	// Relación con la entidad Boleto
    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL)
    private List<BoletoEntity> boletos;
}

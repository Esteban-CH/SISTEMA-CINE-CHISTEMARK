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
@Table(name = "tb_asiento")
public class AsientoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long asientoId;
	private String fila;
	private Integer numero;
	
	@ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
	private SalaEntity sala;
	private String estado;
	
	// Relación con la entidad Boleto
    @OneToMany(mappedBy = "asiento", cascade = CascadeType.ALL)
    private List<BoletoEntity> boletos;
}

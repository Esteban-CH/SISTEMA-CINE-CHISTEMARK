package com.example.demo.entity;

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
@Table(name = "tb_sala")
public class SalaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salaId;
	private String nombre;
	private Integer capacidad;
	private String tipo;
	private String ubicacion;
	private String estado;
	
	// Relación con la entidad Asiento
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private List<AsientoEntity> asientos;

    // Relación con la entidad Función
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private List<FuncionEntity> funciones;
}

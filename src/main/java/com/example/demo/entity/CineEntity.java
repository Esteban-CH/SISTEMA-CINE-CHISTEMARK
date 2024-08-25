package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_cine")
public class CineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cineId;
	
	@Column(length = 45, nullable = false)
	private String nombre;
	
	@Column(length = 255, nullable = false)
	private String direccion;
	
	@Column(length = 9, nullable = false)
	private String telefono;
	
	@Column(length = 255)
	private String email;
}

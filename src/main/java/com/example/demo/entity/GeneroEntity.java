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
@Table(name = "tb_genero")
public class GeneroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long generoId;
	
	@Column(length = 30, nullable = false)
	private String nombre;
}

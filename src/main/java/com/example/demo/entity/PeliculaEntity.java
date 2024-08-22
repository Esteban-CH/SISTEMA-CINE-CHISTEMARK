package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_pelicula")
public class PeliculaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long peliculaId;
	
	@Column(length = 50, nullable = false)
	private String titulo;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String descripcion;
	
	@Column(length = 60, nullable = false)
	private String director;
	
	private Double calificacion;
	private String reparto;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_estreno", nullable = false)
	private Date fchaEstreno;
	private int duracion;
	
	@Column(name = "url_imagen", columnDefinition = "TEXT")
	private String urlImagen;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro", updatable = false, nullable = false)
    private Date fchaRegistro;
    
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualiza", nullable = false)
    private Date fchaActualizacion;
	
	@ManyToOne
	@JoinColumn(name = "genero_id")
	private GeneroEntity genero;
	
	@ManyToOne
    @JoinColumn(name = "productora_id")
	private ProductoraEntity productora;
	
	@ManyToMany
    @JoinTable(
        name = "pelicula_actor",
        joinColumns = @JoinColumn(name = "pelicula_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorEntity> actores;
}

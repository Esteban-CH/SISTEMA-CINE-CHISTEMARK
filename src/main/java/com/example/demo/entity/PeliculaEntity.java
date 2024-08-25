package com.example.demo.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@Column(length = 50)
	private String calificacion;
	
	@Column(length = 255)
	private String reparto;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_estreno", nullable = false)
	private Date fchaEstreno;
	
	private Integer duracion;
	
	@Column(name = "url_imagen", columnDefinition = "TEXT")
	private String urlImagen;
	
	@Column(name = "trailer_url", columnDefinition = "TEXT")
    private String trailerUrl;
    
    @Column(length = 20)
    private String estado;
    
    @Column(length = 50)
    private String paisOrigen;
    
    @Column(length = 50)
    private String idiomaOriginal;
	
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
}

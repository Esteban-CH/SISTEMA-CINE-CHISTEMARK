package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_usuario")
public class UsuarioEntity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long usuarioId;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String apellido;

    @Column(columnDefinition = "CHAR(8)", unique = true, nullable = false)
    private Integer dni;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String direccion;

    @Column(name = "estado_civil", columnDefinition = "VARCHAR(50)", nullable = false)
    private String estadoCivil;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    private String sexo;
    
    @Column(columnDefinition = "VARCHAR(15)")
    private String telefono;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String correo;
    
    @Column(name = "url_imagen", columnDefinition = "TEXT")
    private String urlImagen;

    @Column(name = "nombre_usuario", columnDefinition = "VARCHAR(30)", nullable = false)
    private String nombreUsuario;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String clave;
    
    @Column(name = "tipo_membresia", columnDefinition = "VARCHAR(20) DEFAULT 'REGULAR'")
    private String tipoMembresia;
    
    @Column(name = "puntos_fidelidad", columnDefinition = "INT DEFAULT 0")
    private Integer puntosFidelidad;
    
    @Column(name = "ultimo_ip_acceso", columnDefinition = "VARCHAR(45)")
    private String ultimoIpAcceso;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat
    @Column(name = "fecha_ultimo_acceso")
    private Date fchaUltimoAcceso;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro", updatable = false, nullable = false)
    private Date fchaRegistro;
    
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualiza", nullable = false)
    private Date fchaActualizacion;
    
    @Column(name = "estado_cuenta", columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVO'")
    private String estadoCuenta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private RolEntity rol;
    
 // Relación con la entidad Boleto
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<BoletoEntity> boletos;
}

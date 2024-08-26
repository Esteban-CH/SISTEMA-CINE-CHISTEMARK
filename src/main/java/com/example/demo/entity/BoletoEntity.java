package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_boleto")
public class BoletoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boletoId;
		
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario;

	@ManyToOne
	@JoinColumn(name = "funcion_id")
	private FuncionEntity funcion;
	
	@ManyToOne
	@JoinColumn(name = "asiento_id")
	private AsientoEntity asiento;
	
	private BigDecimal precio;
	
	private String estado;
	
	// Relación con la entidad Pago
    @OneToOne(mappedBy = "boleto", cascade = CascadeType.ALL)
    private PagoEntity pago;
}

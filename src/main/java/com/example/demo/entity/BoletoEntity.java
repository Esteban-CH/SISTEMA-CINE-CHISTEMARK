package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_boleto")
public class BoletoEntity {
	
	private Long boletoId;
	private String numeroAsiento;
	private BigDecimal precio;
	
	@ManyToOne
	@JoinColumn(name = "horario_id")
	private HorarioEntity horario;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario;

	private Date fchaCompra;
}

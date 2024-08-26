package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_pago")
public class PagoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pagoId;
	
	@OneToOne
    @JoinColumn(name = "boleto_id", nullable = false)
	private BoletoEntity boleto;
	private LocalDateTime fchaPago;
	private BigDecimal monto;
	private String metodoPago;
	private String estado;
}

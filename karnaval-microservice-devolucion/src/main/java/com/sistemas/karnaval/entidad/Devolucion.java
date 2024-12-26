package com.sistemas.karnaval.entidad;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "devoluciones")
@Data
public class Devolucion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long idPedido; // Referencia al pedido por su ID

	@Column(nullable = false)
	private String razon;

	@Column(nullable = false)
	private LocalDate fecha;
}

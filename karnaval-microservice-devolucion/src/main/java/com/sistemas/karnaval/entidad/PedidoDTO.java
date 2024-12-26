package com.sistemas.karnaval.entidad;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class PedidoDTO {

	private Long id;
	private Long idCliente;
	private LocalDate fecha;
	private Double total;
	private String estado;
	private List<PedidoDetalleDTO> detalles;
}

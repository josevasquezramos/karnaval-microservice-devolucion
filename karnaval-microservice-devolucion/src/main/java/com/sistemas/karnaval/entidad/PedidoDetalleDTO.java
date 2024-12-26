package com.sistemas.karnaval.entidad;

import lombok.Data;

@Data
public class PedidoDetalleDTO {

	private Long id;
	private Long idProducto;
	private Integer cantidad;
	private Double precioUnitario;
	private Double subtotal;
}

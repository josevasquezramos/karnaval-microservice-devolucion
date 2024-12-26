package com.sistemas.karnaval.servicio;

import java.util.List;

import com.sistemas.karnaval.entidad.Devolucion;

public interface DevolucionService extends iGenericoService<Devolucion, Long> {

	List<Devolucion> listarPorPedido(Long idPedido);
}

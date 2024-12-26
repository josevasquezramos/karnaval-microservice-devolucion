package com.sistemas.karnaval.servicio.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.karnaval.cliente.PedidoFeignClient;
import com.sistemas.karnaval.entidad.Devolucion;
import com.sistemas.karnaval.entidad.PedidoDTO;
import com.sistemas.karnaval.repositorio.DevolucionRepository;
import com.sistemas.karnaval.servicio.DevolucionService;

@Service
public class DevolucionServiceImpl implements DevolucionService {

	@Autowired
	private DevolucionRepository devolucionRepository;

	@Autowired
	private PedidoFeignClient pedidoFeignClient;

	@Override
	public List<Devolucion> listarTodos() {
		return devolucionRepository.findAll();
	}

	@Override
	public Devolucion buscarPorId(Long id) {
		return devolucionRepository.findById(id).orElseThrow(() -> new RuntimeException("Devolución no encontrada"));
	}

	@Override
	public Devolucion crear(Devolucion devolucion) {
		PedidoDTO pedido = pedidoFeignClient.obtenerPedidoPorId(devolucion.getIdPedido());
		if (pedido == null) {
			throw new RuntimeException("Pedido no encontrado");
		}
		devolucion.setFecha(LocalDate.now());
		return devolucionRepository.save(devolucion);
	}

	@Override
	public Devolucion actualizar(Long id, Devolucion devolucion) {
		if (!devolucionRepository.existsById(id)) {
			throw new RuntimeException("Devolución no encontrada");
		}
		devolucion.setId(id);
		return devolucionRepository.save(devolucion);
	}

	@Override
	public void eliminar(Long id) {
		if (!devolucionRepository.existsById(id)) {
			throw new RuntimeException("Devolución no encontrada");
		}
		devolucionRepository.deleteById(id);
	}

	@Override
	public List<Devolucion> listarPorPedido(Long idPedido) {
		return devolucionRepository.findByIdPedido(idPedido);
	}
}

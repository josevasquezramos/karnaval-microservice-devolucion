package com.sistemas.karnaval.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.karnaval.entidad.Devolucion;

public interface DevolucionRepository extends JpaRepository<Devolucion, Long> {

	List<Devolucion> findByIdPedido(Long idPedido);
}

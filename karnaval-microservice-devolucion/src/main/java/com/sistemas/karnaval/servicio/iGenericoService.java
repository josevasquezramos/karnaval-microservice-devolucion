package com.sistemas.karnaval.servicio;

import java.util.List;

public interface iGenericoService<T, ID> {

	List<T> listarTodos();

	T buscarPorId(ID id);

	T crear(T entidad);

	T actualizar(ID id, T entidad);

	void eliminar(ID id);
}

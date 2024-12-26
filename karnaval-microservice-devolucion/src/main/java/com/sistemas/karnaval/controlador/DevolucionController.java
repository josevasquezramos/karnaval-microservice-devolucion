package com.sistemas.karnaval.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.karnaval.entidad.Devolucion;
import com.sistemas.karnaval.servicio.DevolucionService;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionController {

	@Autowired
	private DevolucionService devolucionService;

	@GetMapping
	public ResponseEntity<List<Devolucion>> listarTodos() {
		return ResponseEntity.ok(devolucionService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Devolucion> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(devolucionService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Devolucion> crearDevolucion(@RequestBody Devolucion devolucion) {
		return ResponseEntity.status(HttpStatus.CREATED).body(devolucionService.crear(devolucion));
	}

	@GetMapping("/pedido/{idPedido}")
	public ResponseEntity<List<Devolucion>> listarPorPedido(@PathVariable Long idPedido) {
		return ResponseEntity.ok(devolucionService.listarPorPedido(idPedido));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Devolucion> actualizarDevolucion(@PathVariable Long id, @RequestBody Devolucion devolucion) {
		return ResponseEntity.ok(devolucionService.actualizar(id, devolucion));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarDevolucion(@PathVariable Long id) {
		devolucionService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}

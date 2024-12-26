package com.sistemas.karnaval.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sistemas.karnaval.entidad.PedidoDTO;

@FeignClient(name = "karnaval-microservice-pedido", path = "/api/pedidos")
public interface PedidoFeignClient {
    @GetMapping("/{id}")
    PedidoDTO obtenerPedidoPorId(@PathVariable Long id);
}

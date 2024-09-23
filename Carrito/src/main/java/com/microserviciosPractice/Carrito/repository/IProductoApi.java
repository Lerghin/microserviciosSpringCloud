package com.microserviciosPractice.Carrito.repository;


import com.microserviciosPractice.Carrito.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="Productos")
public interface IProductoApi {

    @GetMapping("/product/get/{codigo_producto}")
    public ProductoDTO getProductoById (@PathVariable("codigo_producto") Long codigo_producto);
}

package com.microserviciosPractice.Carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class ProductoDTO {
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double precio;
}

package com.microserviciosPractice.Carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartProductDTO {
    private Long id_cart;
    private  double total_price;
    private List<ProductoDTO> productoDTOList;

}

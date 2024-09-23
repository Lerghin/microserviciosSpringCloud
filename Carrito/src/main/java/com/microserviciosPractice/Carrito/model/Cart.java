package com.microserviciosPractice.Carrito.model;


import com.microserviciosPractice.Carrito.dto.ProductoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id_cart;
    private  double total_price;
    private List<Long> productos;

}

package com.microserviciosPractice.Ventas.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class SaleCartDTO {
    private Long id_sale;
    private LocalDate dateSale;
    private Long id_cart;
    private  double total_price;
    private List<ProductoDTO> productoDTOList;
}

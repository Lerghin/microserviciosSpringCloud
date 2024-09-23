package com.microserviciosPractice.Ventas.services;

import com.microserviciosPractice.Ventas.dto.CartProductDTO;
import com.microserviciosPractice.Ventas.dto.SaleCartDTO;
import com.microserviciosPractice.Ventas.model.Sale;

import java.util.List;

public interface ISaleService {
    public List<Sale> getSales();
    public Sale save(Sale sale);
    public void deleteSale(Long id_sale);
    public SaleCartDTO findSale(Long id_sale);
    public CartProductDTO findCart(Long id_cart);
}

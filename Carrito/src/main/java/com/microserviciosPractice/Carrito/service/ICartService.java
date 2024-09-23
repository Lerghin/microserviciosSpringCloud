package com.microserviciosPractice.Carrito.service;

import com.microserviciosPractice.Carrito.dto.CartDTO;
import com.microserviciosPractice.Carrito.dto.CartProductDTO;
import com.microserviciosPractice.Carrito.dto.ProductoDTO;
import com.microserviciosPractice.Carrito.model.Cart;

import java.util.List;

public interface ICartService {

    public List<Cart> getCarts();
    public Cart saveCart(CartDTO cartDTO);
    public void deleteCart(Long id_cart);
    public CartProductDTO findCart(Long id_cart);
    public ProductoDTO findProducto(Long codigo_producto);

}

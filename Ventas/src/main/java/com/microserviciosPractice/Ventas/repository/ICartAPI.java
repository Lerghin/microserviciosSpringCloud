package com.microserviciosPractice.Ventas.repository;

import com.microserviciosPractice.Ventas.dto.CartProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cart")
public interface ICartAPI {

     @GetMapping("/cart/get/{id_cart}")
    public CartProductDTO getCartById(@PathVariable("id_cart") Long id_cart);

}

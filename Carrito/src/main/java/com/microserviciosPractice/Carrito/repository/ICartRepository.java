package com.microserviciosPractice.Carrito.repository;

import com.microserviciosPractice.Carrito.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
}

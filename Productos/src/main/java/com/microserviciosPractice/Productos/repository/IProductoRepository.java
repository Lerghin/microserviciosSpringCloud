package com.microserviciosPractice.Productos.repository;

import com.microserviciosPractice.Productos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Product, Long>  {
}


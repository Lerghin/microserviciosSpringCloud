package com.microserviciosPractice.Productos.service;

import com.microserviciosPractice.Productos.model.Product;
import com.microserviciosPractice.Productos.repository.IProductoRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.aspectj.asm.IProgramElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements  IProductoService{

    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public List<Product> getProducts() {
        return productoRepository.findAll();
    }

    @Override
    public Product saveProduct(Product prod) {
        Product product= productoRepository.save(prod);
        return   product;

    }

    @Override
    public void deleteProduct(Long codigo_producto) {
      productoRepository.deleteById(codigo_producto);

    }

    @Override

    public Product findProduct(Long codigo_producto) {
       Product product= productoRepository.findById(codigo_producto).orElseThrow(null);
       return product;

    }
}

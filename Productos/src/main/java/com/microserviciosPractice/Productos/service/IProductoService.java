package com.microserviciosPractice.Productos.service;

import com.microserviciosPractice.Productos.model.Product;

import java.util.List;

public interface IProductoService {
public List<Product> getProducts();
public Product saveProduct(Product prod);
public void deleteProduct(Long codigo_producto);
public Product findProduct(Long codigo_producto);




}

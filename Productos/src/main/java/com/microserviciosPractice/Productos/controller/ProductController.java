package com.microserviciosPractice.Productos.controller;

import com.microserviciosPractice.Productos.model.Product;
import com.microserviciosPractice.Productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private  int serverPort;

    @Autowired
    private IProductoService productoService ;

    @GetMapping("/get")
    public List<Product> getProduct(){
       return productoService.getProducts();
    }
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        Product product1= productoService.saveProduct(product);
        return product1;
    }

    @DeleteMapping("/delete/{codigo_producto}")
    public String deleteProduct(@PathVariable Long codigo_producto ){
        productoService.deleteProduct(codigo_producto);
        return "fue borrada";

    }


    @GetMapping("/get/{codigo_producto}")
    public Product findProduct(@PathVariable Long codigo_producto){
        Product product1= productoService.findProduct(codigo_producto);
        System.out.println("I am in the port:" + serverPort);
        return product1;
    }

}

package com.microserviciosPractice.Carrito.controller;

import com.microserviciosPractice.Carrito.dto.CartDTO;
import com.microserviciosPractice.Carrito.dto.CartProductDTO;
import com.microserviciosPractice.Carrito.dto.ProductoDTO;
import com.microserviciosPractice.Carrito.model.Cart;
import com.microserviciosPractice.Carrito.repository.ICartRepository;
import com.microserviciosPractice.Carrito.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;


    @Value("${server.port}")
    @Autowired
    private  int serverPort;

    @GetMapping("/get")
    public List<Cart> getCarts(){
        return cartService.getCarts();
    }
    @PostMapping("/create")
    public Cart createProduct(@RequestBody CartDTO cartDTO){

        Cart cartSaved= cartService.saveCart(cartDTO);
        return cartSaved;
    }

    @DeleteMapping("/delete/{id_cart}")
    public String delete(@PathVariable Long id_cart ){
       cartService.deleteCart(id_cart);
        return "fue borrada";

    }


    @GetMapping("/get/{id_cart}")
    public CartProductDTO find(@PathVariable Long id_cart){
       CartProductDTO cart= cartService.findCart(id_cart);
        System.out.println("I am in the port:" + serverPort);
        return cart;
    }

    @GetMapping("/getProd/{codigo_producto}")
    public ProductoDTO findProduct(@PathVariable Long codigo_producto){
       ProductoDTO productoDTO= cartService.findProducto(codigo_producto);
        return  productoDTO;
    }


}

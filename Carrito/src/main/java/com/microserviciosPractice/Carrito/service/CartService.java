package com.microserviciosPractice.Carrito.service;

import com.microserviciosPractice.Carrito.dto.CartDTO;
import com.microserviciosPractice.Carrito.dto.CartProductDTO;
import com.microserviciosPractice.Carrito.dto.ProductoDTO;
import com.microserviciosPractice.Carrito.model.Cart;
import com.microserviciosPractice.Carrito.repository.ICartRepository;
import com.microserviciosPractice.Carrito.repository.IProductoApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements  ICartService{

    @Autowired
    private ICartRepository cartRepository;
    @Autowired
    private IProductoApi productoApi;

    @Override
    public List<Cart> getCarts() {
        return cartRepository.findAll() ;
    }

    @Override
    public Cart saveCart(CartDTO cartDTO) {
        Cart cartSaved= new Cart();
        double precio=0.00;
        for(Long proCod: cartDTO.getProductoList()){
            ProductoDTO productoDTO= productoApi.getProductoById(proCod);
            precio+=productoDTO.getPrecio();

        }
        cartSaved.setTotal_price(precio);
       cartSaved.setProductos(cartDTO.getProductoList());
       cartRepository.save(cartSaved);
        return cartSaved;
    }

    @Override
    public void deleteCart(Long id_cart) {
      cartRepository.deleteById(id_cart);
    }

    @Override
    public CartProductDTO findCart(Long id_cart) {
    Cart cart= cartRepository.findById(id_cart).orElseThrow(null);
    List<ProductoDTO> productoDTOList= new ArrayList<>();
    CartProductDTO cartProductDTO= new CartProductDTO();
    cartProductDTO.setId_cart(cart.getId_cart());
    cartProductDTO.setTotal_price(cart.getTotal_price());
        for(Long proCod: cart.getProductos()){
            ProductoDTO productoDTO= productoApi.getProductoById(proCod);
            productoDTOList.add(productoDTO);

        }

        cartProductDTO.setProductoDTOList(productoDTOList);

        return  cartProductDTO;
    }

    @Override
    @CircuitBreaker(name="Productos", fallbackMethod = "fallbackGetProducts")
    @Retry(name="Productos")
    public ProductoDTO findProducto(Long codigo_producto) {
        ProductoDTO productoDTO= productoApi.getProductoById(codigo_producto);
        //createExcepction();
        return productoDTO;
    }


    public ProductoDTO fallbackGetProducts (Throwable throwable){

        return new ProductoDTO(9999999L, "Fallido", "Fallido", 0.00);
    }


    public void createExcepction(){

        throw  new IllegalArgumentException("Prueba Resiliencia y Circuit breaker");
    }

}

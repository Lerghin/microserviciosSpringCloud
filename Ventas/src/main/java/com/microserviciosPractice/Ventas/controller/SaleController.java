package com.microserviciosPractice.Ventas.controller;

import com.microserviciosPractice.Ventas.dto.CartProductDTO;
import com.microserviciosPractice.Ventas.dto.SaleCartDTO;
import com.microserviciosPractice.Ventas.model.Sale;
import com.microserviciosPractice.Ventas.services.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private ISaleService saleService;

    @GetMapping("/get")
    public List<Sale> getSales(){
        return saleService.getSales();
    }
    @PostMapping("/create")
    public Sale createSale(@RequestBody Sale sale){

       Sale saleSaved= saleService.save(sale);
        return saleSaved;
    }

    @DeleteMapping("/delete/{id_sale}")
    public String delete(@PathVariable Long id_sale ){
       saleService.deleteSale(id_sale);
        return "fue borrada";

    }


    @GetMapping("/get/{id_sale}")
    public SaleCartDTO find(@PathVariable Long id_sale){
        SaleCartDTO sale= saleService.findSale(id_sale);
        return sale;
    }

    @GetMapping("/get/cart/{id_cart}")
    public CartProductDTO findCart(@PathVariable Long id_cart){
     CartProductDTO cartDTO= saleService.findCart(id_cart);
        return  cartDTO;
    }




}

package com.microserviciosPractice.Ventas.services;

import com.microserviciosPractice.Ventas.dto.CartProductDTO;
import com.microserviciosPractice.Ventas.dto.SaleCartDTO;
import com.microserviciosPractice.Ventas.model.Sale;
import com.microserviciosPractice.Ventas.repository.ICartAPI;
import com.microserviciosPractice.Ventas.repository.ISaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements  ISaleService {

    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private ICartAPI cartAPI;
    @Override
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale save(Sale sale) {


       Sale sale1= new Sale();
        CartProductDTO cartProductDTO = cartAPI.getCartById(sale.getId_cart());
        if(cartProductDTO==null){
            throw new EntityNotFoundException("Cart not found for ID: " + sale.getId_cart());
        }else{
         sale1.setId_cart(sale.getId_cart());
         sale1.setDateSale(sale.getDateSale());
         saleRepository.save(sale1);
        }

       return sale1;
    }

    @Override
    public void deleteSale(Long id_sale) {
       saleRepository.deleteById(id_sale);
    }

    @Override
    public SaleCartDTO findSale(Long id_sale) {
        Sale sale= saleRepository.findById(id_sale).orElseThrow(null);
        SaleCartDTO saleCartDTO= new SaleCartDTO();
        saleCartDTO.setId_sale(sale.getId_sale());
        saleCartDTO.setId_cart(sale.getId_cart());
        CartProductDTO cartProductDTO = cartAPI.getCartById(sale.getId_cart());
        saleCartDTO.setProductoDTOList(cartProductDTO.getProductoDTOList());
        saleCartDTO.setTotal_price(cartProductDTO.getTotal_price());
        saleCartDTO.setDateSale(sale.getDateSale());
        return saleCartDTO;
    }

    @Override
    public CartProductDTO findCart(Long id_cart) {
        CartProductDTO cartDTO= cartAPI.getCartById(id_cart);
        return cartDTO;
    }
}

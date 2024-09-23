package com.microserviciosPractice.Ventas.repository;

import com.microserviciosPractice.Ventas.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository  extends JpaRepository<Sale, Long> {
}

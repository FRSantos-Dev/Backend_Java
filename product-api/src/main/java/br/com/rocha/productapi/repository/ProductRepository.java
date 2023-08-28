package br.com.rocha.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.rocha.productapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    @Query(value = "select p")
    
}

package br.com.rocha.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rocha.productapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
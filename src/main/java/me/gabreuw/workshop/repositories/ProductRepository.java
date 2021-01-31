package me.gabreuw.workshop.repositories;

import me.gabreuw.workshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
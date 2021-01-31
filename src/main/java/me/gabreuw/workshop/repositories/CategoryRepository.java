package me.gabreuw.workshop.repositories;

import me.gabreuw.workshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
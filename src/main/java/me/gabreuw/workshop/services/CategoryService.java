package me.gabreuw.workshop.services;

import me.gabreuw.workshop.entities.Category;
import me.gabreuw.workshop.entities.User;
import me.gabreuw.workshop.repositories.CategoryRepository;
import me.gabreuw.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.get();
    }
}

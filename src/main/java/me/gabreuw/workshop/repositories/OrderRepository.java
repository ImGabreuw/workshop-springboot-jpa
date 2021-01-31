package me.gabreuw.workshop.repositories;

import me.gabreuw.workshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
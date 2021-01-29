package me.gabreuw.workshop.repositories;

import me.gabreuw.workshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

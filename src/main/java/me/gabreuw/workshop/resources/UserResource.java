package me.gabreuw.workshop.resources;

import me.gabreuw.workshop.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User maria = new User(1L, "Maria", "maria@gmail.com", "99999999", "123456789");

        return ResponseEntity
                .ok()
                .body(maria);
    }

}

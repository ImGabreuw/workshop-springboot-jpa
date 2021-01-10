package me.gabreuw.workshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

    private Long id;

    private String name;
    private String email;
    private String phone;
    private String password;
}

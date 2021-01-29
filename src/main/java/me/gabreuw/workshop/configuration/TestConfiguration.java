package me.gabreuw.workshop.configuration;

import me.gabreuw.workshop.entities.User;
import me.gabreuw.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration // Informando o Spring que esta classe é uma Classe de Configuração
@Profile("test") // Seleção do perfil que esta classe irá atuar
public class TestConfiguration implements CommandLineRunner {

    /* Interface CommandLineRunner

    - Quando a aplicação for iniciada o método 'run' será executado
     */

    @Autowired // Injeção de dependência automática
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User maria_brown = new User(
                null,
                "Maria Brown",
                "maria@gmail.com",
                "988888888",
                "123456"
        );
        User alex_green = new User(
                null,
                "Alex Green",
                "alex@gmail.com",
                "977777777",
                "123456"
        );

        repository.saveAll(List.of(maria_brown, alex_green));
    }
}

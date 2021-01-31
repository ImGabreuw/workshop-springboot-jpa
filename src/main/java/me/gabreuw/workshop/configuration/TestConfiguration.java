package me.gabreuw.workshop.configuration;

import me.gabreuw.workshop.entities.Category;
import me.gabreuw.workshop.entities.Order;
import me.gabreuw.workshop.entities.User;
import me.gabreuw.workshop.entities.enums.OrderStatus;
import me.gabreuw.workshop.repositories.CategoryRepository;
import me.gabreuw.workshop.repositories.OrderRepository;
import me.gabreuw.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration // Informando o Spring que esta classe é uma Classe de Configuração
@Profile("test") // Seleção do perfil que esta classe irá atuar
public class TestConfiguration implements CommandLineRunner {

    /* Interface CommandLineRunner

    - Quando a aplicação for iniciada o método 'run' será executado
     */

    @Autowired // Injeção de dependência automática
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeEntities();
    }

    private void initializeEntities() {
        /*
        CATEGORY
         */
        Category electronics = new Category(null, "Electronics");
        Category books = new Category(null, "Books");
        Category computers = new Category(null, "Computers");

        /*
        USER
         */
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

        /*
        ORDER
         */
        Order order1 = new Order(
                null,
                Instant.parse("2019-06-20T19:53:07Z"),
                OrderStatus.PAID,
                maria_brown
        );
        Order order2 = new Order(
                null,
                Instant.parse("2019-07-21T03:42:10Z"),
                OrderStatus.WAITING_PAYMENT,
                alex_green);
        Order order3 = new Order(
                null,
                Instant.parse("2019-07-22T15:21:22Z"),
                OrderStatus.WAITING_PAYMENT,
                maria_brown
        );

        categoryRepository.saveAll(List.of(electronics, books, computers));
        userRepository.saveAll(List.of(maria_brown, alex_green));
        orderRepository.saveAll(List.of(order1, order2, order3));
    }
}

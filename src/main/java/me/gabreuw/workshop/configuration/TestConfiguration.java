package me.gabreuw.workshop.configuration;

import me.gabreuw.workshop.entities.Category;
import me.gabreuw.workshop.entities.Order;
import me.gabreuw.workshop.entities.Product;
import me.gabreuw.workshop.entities.User;
import me.gabreuw.workshop.entities.enums.OrderStatus;
import me.gabreuw.workshop.repositories.CategoryRepository;
import me.gabreuw.workshop.repositories.OrderRepository;
import me.gabreuw.workshop.repositories.ProductRepository;
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
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        mockData();
    }

    private void mockData() {
        /*
        CATEGORY
         */
        Category electronics = new Category(null, "Electronics");
        Category books = new Category(null, "Books");
        Category computers = new Category(null, "Computers");

        categoryRepository.saveAll(List.of(electronics, books, computers));

        /*
        PRODUCT
         */
        Product the_lord_of_the_rings = new Product(
                null,
                "The Lord of the Rings",
                "Lorem ipsum dolor sit amet, consectetur.",
                90.5,
                ""
        );
        Product smart_tv = new Product(
                null,
                "Smart TV",
                "Nulla eu imperdiet purus. Maecenas ante.",
                2190.0,
                ""
        );
        Product macbook_pro = new Product(
                null,
                "Macbook Pro",
                "Nam eleifend maximus tortor, at mollis.",
                1250.0,
                ""
        );
        Product pc_gamer = new Product(
                null, "PC Gamer",
                "Donec aliquet odio ac rhoncus cursus.",
                1200.0,
                ""
        );
        Product rails_for_dummies = new Product(
                null,
                "Rails for Dummies",
                "Cras fringilla convallis sem vel faucibus.",
                100.99,
                ""
        );

        productRepository.saveAll(List.of(macbook_pro, pc_gamer, rails_for_dummies, smart_tv, the_lord_of_the_rings));

        /*
        ASSOCIATION
         */

        the_lord_of_the_rings.getCategories().add(books);

        smart_tv.getCategories().add(electronics);
        smart_tv.getCategories().add(computers);

        macbook_pro.getCategories().add(computers);

        pc_gamer.getCategories().add(computers);

        rails_for_dummies.getCategories().add(books);

        productRepository.saveAll(List.of(macbook_pro, pc_gamer, rails_for_dummies, smart_tv, the_lord_of_the_rings));

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

        userRepository.saveAll(List.of(maria_brown, alex_green));

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

        orderRepository.saveAll(List.of(order1, order2, order3));
    }
}

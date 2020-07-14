package mate.academy.springbootapp;

import java.util.ArrayList;
import java.util.List;
import mate.academy.springbootapp.model.Product;
import mate.academy.springbootapp.model.Review;
import mate.academy.springbootapp.model.User;
import mate.academy.springbootapp.model.dto.ReviewDto;
import mate.academy.springbootapp.model.mapper.ProductMapper;
import mate.academy.springbootapp.model.mapper.ReviewMapper;
import mate.academy.springbootapp.model.mapper.UserMapper;
import mate.academy.springbootapp.service.ProductService;
import mate.academy.springbootapp.service.ReviewService;
import mate.academy.springbootapp.service.UserService;
import mate.academy.springbootapp.service.impl.CsvFileParserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAppApplication {
    private static final String FILEPATH = "src/test/resources/reviews-test.csv";

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner saveData(UserService userService,
                                      ProductService productService,
                                      ReviewService reviewService) {
        return (args) -> {
            var parser = new CsvFileParserServiceImpl(new ReviewMapper());
            List<ReviewDto> dtoList = parser.parseCsvFile(FILEPATH);
            var userMapper = new UserMapper();
            var productMapper = new ProductMapper();
            var reviewMapper = new ReviewMapper();
            List<User> users = new ArrayList<>();
            List<Product> products = new ArrayList<>();
            List<Review> reviews = new ArrayList<>();
            for (var dto : dtoList) {
                users.add(userMapper.getUserFromReviewDto(dto));
                products.add(productMapper.getProductFromReviewDto(dto));
                reviews.add(reviewMapper.getReviewFromReviewDto(dto));
            }
            userService.addAll(users);
            productService.addAll(products);
            reviewService.addAll(reviews);
        };
    }
}

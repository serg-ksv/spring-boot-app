package mate.academy.springbootapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.Customer;
import mate.academy.springbootapp.model.Product;
import mate.academy.springbootapp.model.Review;
import mate.academy.springbootapp.model.Role;
import mate.academy.springbootapp.model.User;
import mate.academy.springbootapp.model.dto.ReviewDto;
import mate.academy.springbootapp.model.mapper.ProductMapper;
import mate.academy.springbootapp.model.mapper.ReviewMapper;
import mate.academy.springbootapp.model.mapper.UserMapper;
import mate.academy.springbootapp.service.CustomerService;
import mate.academy.springbootapp.service.ProductService;
import mate.academy.springbootapp.service.ReviewService;
import mate.academy.springbootapp.service.RoleService;
import mate.academy.springbootapp.service.UserService;
import mate.academy.springbootapp.service.impl.CsvFileParserServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InjectDataController {
    private static final String FILEPATH = "src/test/resources/reviews-test.csv";
    private final UserService userService;
    private final ProductService productService;
    private final ReviewService reviewService;
    private final RoleService roleService;
    private final CustomerService customerService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final ReviewMapper reviewMapper;

    @PostConstruct
    public void init() {
        injectData();
        injectRoles();
        injectCustomers();
    }

    private void injectData() {
        var parser = new CsvFileParserServiceImpl(new ReviewMapper());
        List<ReviewDto> dtoList = parser.parseCsvFile(FILEPATH);
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
    }

    private void injectRoles() {
        roleService.add(new Role(Role.RoleName.ADMIN));
        roleService.add(new Role(Role.RoleName.USER));
    }

    private void injectCustomers() {
        var roleAdmin = roleService.findByName(Role.RoleName.ADMIN);
        var roleUser = roleService.findByName(Role.RoleName.USER);
        var admin = new Customer()
                .setLogin("admin")
                .setPassword(passwordEncoder.encode("1"))
                .setRoles(Set.of(roleAdmin));
        var user = new Customer()
                .setLogin("user")
                .setPassword(passwordEncoder.encode("2"))
                .setRoles(Set.of(roleUser));
        customerService.add(admin);
        customerService.add(user);
    }
}

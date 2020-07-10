package mate.academy.springbootapp.repository;

import mate.academy.springbootapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

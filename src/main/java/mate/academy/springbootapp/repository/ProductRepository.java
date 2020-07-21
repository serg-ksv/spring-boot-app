package mate.academy.springbootapp.repository;

import java.util.List;
import mate.academy.springbootapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "SELECT p.id FROM product p "
            + "JOIN review r ON p.id = r.product_id "
            + "GROUP BY p.id "
            + "ORDER BY COUNT(*) DESC LIMIT :limit", nativeQuery = true)
    List<Product> getMostCommented(int limit);
}

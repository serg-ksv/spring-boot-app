package mate.academy.springbootapp.service;

import java.util.List;
import mate.academy.springbootapp.model.Product;

public interface ProductService {
    void addAll(List<Product> products);

    List<Product> getMostCommented(int limit);
}

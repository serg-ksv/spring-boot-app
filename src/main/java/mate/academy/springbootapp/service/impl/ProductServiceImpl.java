package mate.academy.springbootapp.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.Product;
import mate.academy.springbootapp.repository.ProductRepository;
import mate.academy.springbootapp.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public void addAll(List<Product> products) {
        repository.saveAll(products);
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getMostCommented(int limit) {
        return repository.getMostCommented(limit);
    }
}

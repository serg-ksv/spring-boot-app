package mate.academy.springbootapp.model.mapper;

import mate.academy.springbootapp.model.Product;
import mate.academy.springbootapp.model.dto.ReviewDto;

public class ProductMapper {
    public Product getProductFromReviewDto(ReviewDto reviewDto) {
        Product product = new Product();
        product.setId(reviewDto.getProductId());
        return product;
    }
}

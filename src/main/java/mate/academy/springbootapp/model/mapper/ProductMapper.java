package mate.academy.springbootapp.model.mapper;

import mate.academy.springbootapp.model.Product;
import mate.academy.springbootapp.model.dto.ProductResponseDto;
import mate.academy.springbootapp.model.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product getProductFromReviewDto(ReviewDto reviewDto) {
        return new Product().setId(reviewDto.getProductId());
    }

    public ProductResponseDto getDtoFromProduct(Product product) {
        return new ProductResponseDto()
                .setProductId(product.getId())
                .setNumberOfReviews(product.getReviews().size());
    }
}

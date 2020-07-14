package mate.academy.springbootapp.model.mapper;

import mate.academy.springbootapp.model.Product;
import mate.academy.springbootapp.model.dto.ProductResponseDto;
import mate.academy.springbootapp.model.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product getProductFromReviewDto(ReviewDto reviewDto) {
        Product product = new Product();
        product.setId(reviewDto.getProductId());
        return product;
    }

    public ProductResponseDto getDtoFromProduct(Product product) {
        var responseDto = new ProductResponseDto();
        responseDto.setProductId(product.getId());
        responseDto.setNumberOfReviews(product.getReviews().size());
        return responseDto;
    }
}

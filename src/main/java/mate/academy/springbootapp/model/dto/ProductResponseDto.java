package mate.academy.springbootapp.model.dto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private String productId;
    private int numberOfReviews;
}

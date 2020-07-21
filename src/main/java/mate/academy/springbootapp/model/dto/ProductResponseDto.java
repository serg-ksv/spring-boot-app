package mate.academy.springbootapp.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductResponseDto {
    private String productId;
    private int numberOfReviews;
}

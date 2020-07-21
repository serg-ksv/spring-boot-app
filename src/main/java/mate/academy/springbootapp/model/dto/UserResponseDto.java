package mate.academy.springbootapp.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserResponseDto {
    private String profileName;
    private int numberOfReviews;
}

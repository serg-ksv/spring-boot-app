package mate.academy.springbootapp.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReviewUpdateDto {
    private Long id;
    private int score;
    private String summary;
    private String text;
}

package mate.academy.springbootapp.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CustomerRequestDto {
    @Size(min = 6, max = 20)
    private String login;
    @NotBlank(message = "Password can't be empty!")
    private String password;
    @NotBlank(message = "repeatPassword can't be empty!")
    private String repeatPassword;
}

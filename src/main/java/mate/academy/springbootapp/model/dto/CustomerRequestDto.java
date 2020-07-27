package mate.academy.springbootapp.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;
import mate.academy.springbootapp.validator.PasswordsMatch;

@Data
@Accessors(chain = true)
@PasswordsMatch
public class CustomerRequestDto {
    @Size(min = 6, max = 20)
    private String login;
    @NotBlank(message = "Password can't be empty!")
    private String password;
    @NotBlank(message = "repeatPassword can't be empty!")
    private String repeatPassword;
}

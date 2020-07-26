package mate.academy.springbootapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mate.academy.springbootapp.model.dto.CustomerRequestDto;

public class PasswordsMatchValidator implements
        ConstraintValidator<PasswordsMatch, CustomerRequestDto> {

    @Override
    public boolean isValid(CustomerRequestDto requestDto, ConstraintValidatorContext context) {
        return requestDto.getPassword().equals(requestDto.getRepeatPassword());
    }
}

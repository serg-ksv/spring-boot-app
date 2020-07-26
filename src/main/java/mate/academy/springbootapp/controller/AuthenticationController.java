package mate.academy.springbootapp.controller;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.dto.CustomerRequestDto;
import mate.academy.springbootapp.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody CustomerRequestDto requestDto) {
        authenticationService.register(requestDto.getLogin(), requestDto.getPassword());
    }
}

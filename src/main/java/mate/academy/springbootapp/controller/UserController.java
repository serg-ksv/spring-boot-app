package mate.academy.springbootapp.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.dto.UserResponseDto;
import mate.academy.springbootapp.model.mapper.UserMapper;
import mate.academy.springbootapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/most-active")
    public List<UserResponseDto> getMostActive(@RequestParam(defaultValue = "1000") int limit) {
        return userService.getMostActive(limit).stream()
                .map(userMapper::getDtoFromUser)
                .collect(Collectors.toList());
    }
}

package mate.academy.springbootapp.security.impl;

import java.util.Set;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.Customer;
import mate.academy.springbootapp.model.Role;
import mate.academy.springbootapp.security.AuthenticationService;
import mate.academy.springbootapp.service.CustomerService;
import mate.academy.springbootapp.service.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final CustomerService customerService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Customer register(String login, String password) {
        var roleUser = roleService.findByName(Role.RoleName.USER);
        return customerService.add(new Customer()
                .setLogin(login)
                .setPassword(passwordEncoder.encode(password))
                .setRoles(Set.of(roleUser)));
    }
}

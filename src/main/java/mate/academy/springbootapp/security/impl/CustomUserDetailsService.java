package mate.academy.springbootapp.security.impl;

import lombok.AllArgsConstructor;
import mate.academy.springbootapp.service.CustomerService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var customer = customerService.findByLogin(login);
        UserBuilder builder = null;
        if (customer != null) {
            builder = User.withUsername(login);
            builder.password(customer.getPassword());
            String[] roles = customer.getRoles().stream()
                    .map(role -> role.getName().name())
                    .toArray(String[]::new);
            builder.roles(roles);
        } else {
            throw new UsernameNotFoundException("Customer not found.");
        }
        return builder.build();
    }
}

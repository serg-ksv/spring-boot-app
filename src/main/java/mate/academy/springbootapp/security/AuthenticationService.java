package mate.academy.springbootapp.security;

import mate.academy.springbootapp.model.Customer;

public interface AuthenticationService {
    Customer register(String login, String password);
}

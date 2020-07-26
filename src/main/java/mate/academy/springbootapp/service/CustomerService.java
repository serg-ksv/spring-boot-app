package mate.academy.springbootapp.service;

import mate.academy.springbootapp.model.Customer;

public interface CustomerService {
    Customer add(Customer customer);

    Customer findByLogin(String login);
}

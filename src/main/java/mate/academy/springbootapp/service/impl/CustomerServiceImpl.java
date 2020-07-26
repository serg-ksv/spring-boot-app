package mate.academy.springbootapp.service.impl;

import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.Customer;
import mate.academy.springbootapp.repository.CustomerRepository;
import mate.academy.springbootapp.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    @Override
    public Customer add(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer findByLogin(String login) {
        return repository.findByLogin(login);
    }
}

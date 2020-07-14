package mate.academy.springbootapp.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.User;
import mate.academy.springbootapp.repository.UserRepository;
import mate.academy.springbootapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public void addAll(List<User> users) {
        repository.saveAll(users);
    }

    @Override
    public List<User> getMostActive(int limit) {
        return repository.getMostActive(limit);
    }
}

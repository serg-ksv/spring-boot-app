package mate.academy.springbootapp.service;

import java.util.List;
import mate.academy.springbootapp.model.User;

public interface UserService {
    void addAll(List<User> users);

    List<User> getMostActive(int limit);
}

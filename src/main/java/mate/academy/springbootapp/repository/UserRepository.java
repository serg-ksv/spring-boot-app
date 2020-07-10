package mate.academy.springbootapp.repository;

import mate.academy.springbootapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

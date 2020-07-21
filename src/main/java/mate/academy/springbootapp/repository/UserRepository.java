package mate.academy.springbootapp.repository;

import java.util.List;
import mate.academy.springbootapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT u.profile_name, u.id FROM user u "
            + "JOIN review r ON u.id = r.user_id "
            + "GROUP BY u.profile_name, u.id "
            + "ORDER BY COUNT(*) DESC LIMIT :limit", nativeQuery = true)
    List<User> getMostActive(int limit);
}

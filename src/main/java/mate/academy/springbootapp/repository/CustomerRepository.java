package mate.academy.springbootapp.repository;

import mate.academy.springbootapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM customer c LEFT JOIN FETCH c.roles WHERE c.login = :login")
    Customer findByLogin(@Param("login") String login);
}

package mate.academy.springbootapp.repository;

import mate.academy.springbootapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

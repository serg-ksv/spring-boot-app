package mate.academy.springbootapp.repository;

import java.util.List;
import mate.academy.springbootapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT text FROM review")
    List<String> getAllText();
}

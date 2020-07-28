package mate.academy.springbootapp.service;

import java.util.List;
import mate.academy.springbootapp.model.Review;

public interface ReviewService {
    Review add(Review review);

    void addAll(List<Review> reviews);

    Review findByIdAndCustomerLogin(Long id, String login);

    Review update(Review review);

    void delete(Long id);

    List<String> getMostUsedWords(int limit);
}

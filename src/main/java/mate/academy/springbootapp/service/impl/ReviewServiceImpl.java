package mate.academy.springbootapp.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.Review;
import mate.academy.springbootapp.repository.ReviewRepository;
import mate.academy.springbootapp.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;

    @Override
    public void addAll(List<Review> reviews) {
        repository.saveAll(reviews);
    }
}

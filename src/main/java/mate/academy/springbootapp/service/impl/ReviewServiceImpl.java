package mate.academy.springbootapp.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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
    public Review add(Review review) {
        return repository.save(review);
    }

    @Override
    public void addAll(List<Review> reviews) {
        repository.saveAll(reviews);
    }

    @Override
    public Review findByIdAndCustomerLogin(Long id, String login) {
        return repository.findReviewByIdAndCustomer_Login(id, login);
    }

    @Override
    public Review update(Review review) {
        return repository.save(review);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<String> getMostUsedWords(int limit) {
        List<String> allText = repository.getAllText();
        List<String> words = new ArrayList<>();
        allText.stream()
                .map(this::extractWords)
                .forEach(words::addAll);
        Map<String, Integer> map = words.stream()
                .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(limit)
                .collect(Collectors.toList());
    }

    private List<String> extractWords(String text) {
        var pattern = Pattern.compile("[\\w']+");
        var matcher = pattern.matcher(text);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group().toLowerCase());
        }
        return words;
    }
}

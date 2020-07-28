package mate.academy.springbootapp.controller;

import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.dto.ReviewCreateDto;
import mate.academy.springbootapp.model.dto.ReviewResponseDto;
import mate.academy.springbootapp.model.dto.ReviewUpdateDto;
import mate.academy.springbootapp.model.mapper.ReviewMapper;
import mate.academy.springbootapp.service.CustomerService;
import mate.academy.springbootapp.service.ProductService;
import mate.academy.springbootapp.service.ReviewService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final CustomerService customerService;
    private final ProductService productService;
    private final ReviewMapper reviewMapper;

    @GetMapping("/most-used-words")
    @ApiOperation(value = "Finds the most used words")
    public List<String> getMostUsedWords(@RequestParam(defaultValue = "1000") int limit) {
        return reviewService.getMostUsedWords(limit);
    }

    @PostMapping
    public ReviewResponseDto create(@RequestBody ReviewCreateDto dto,
                                    Authentication authentication) {
        var customer = customerService.findByLogin(authentication.getName());
        var product = productService.findById(dto.getProductId());
        var review = reviewMapper.getReviewFromReviewCreateDto(dto)
                .setCustomer(customer)
                .setProduct(product);
        return reviewMapper.getReviewResponseDtoFromReview(reviewService.add(review));
    }

    @PutMapping
    public ReviewResponseDto update(@RequestBody ReviewUpdateDto dto,
                                    Authentication authentication) {
        var review = reviewService.findByIdAndCustomerLogin(dto.getId(), authentication.getName());
        review.setScore(dto.getScore())
                .setSummary(dto.getSummary())
                .setText(dto.getText())
                .setTime(LocalDateTime.now());
        return reviewMapper.getReviewResponseDtoFromReview(reviewService.update(review));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}

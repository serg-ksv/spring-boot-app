package mate.academy.springbootapp.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/most-used-words")
    @ApiOperation(value = "Finds the most used words")
    public List<String> getMostUsedWords(@RequestParam(defaultValue = "1000") int limit) {
        return reviewService.getMostUsedWords(limit);
    }
}

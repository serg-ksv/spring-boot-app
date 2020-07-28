package mate.academy.springbootapp.model.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import mate.academy.springbootapp.model.Product;
import mate.academy.springbootapp.model.Review;
import mate.academy.springbootapp.model.User;
import mate.academy.springbootapp.model.dto.ReviewCreateDto;
import mate.academy.springbootapp.model.dto.ReviewDto;
import mate.academy.springbootapp.model.dto.ReviewResponseDto;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewDto getDtoFromCsvRecord(CSVRecord csvRecord) {
        return new ReviewDto()
                .setId(Long.parseLong(csvRecord.get("Id")))
                .setProductId(csvRecord.get("ProductId"))
                .setUserId(csvRecord.get("UserId"))
                .setProfileName(csvRecord.get("ProfileName"))
                .setHelpfulnessNumerator(Integer
                        .parseInt(csvRecord.get("HelpfulnessNumerator")))
                .setHelpfulnessDenominator(Integer
                        .parseInt(csvRecord.get("HelpfulnessDenominator")))
                .setScore(Integer.parseInt(csvRecord.get("Score")))
                .setTime(convertToLocalDateTime(csvRecord.get("Time")))
                .setSummary(csvRecord.get("Summary"))
                .setText(csvRecord.get("Text"));
    }

    public Review getReviewFromReviewDto(ReviewDto reviewDto) {
        return new Review()
                .setText(reviewDto.getText())
                .setSummary(reviewDto.getSummary())
                .setTime(reviewDto.getTime())
                .setScore(reviewDto.getScore())
                .setHelpfulnessNumerator(reviewDto.getHelpfulnessNumerator())
                .setHelpfulnessDenominator(reviewDto.getHelpfulnessDenominator())
                .setProduct(new Product()
                        .setId(reviewDto.getProductId()))
                .setUser(new User()
                        .setId(reviewDto.getUserId())
                        .setProfileName(reviewDto.getProfileName()));
    }

    public ReviewResponseDto getReviewResponseDtoFromReview(Review review) {
        return new ReviewResponseDto()
                .setId(review.getId())
                .setScore(review.getScore())
                .setSummary(review.getSummary())
                .setText(review.getText());
    }

    public Review getReviewFromReviewCreateDto(ReviewCreateDto dto) {
        return new Review()
                .setTime(LocalDateTime.now())
                .setScore(dto.getScore())
                .setSummary(dto.getSummary())
                .setText(dto.getText());
    }

    private LocalDateTime convertToLocalDateTime(String time) {
        var instant = Instant.ofEpochMilli(Long.parseLong(time));
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}

package mate.academy.springbootapp.model.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import mate.academy.springbootapp.model.Product;
import mate.academy.springbootapp.model.Review;
import mate.academy.springbootapp.model.User;
import mate.academy.springbootapp.model.dto.ReviewDto;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewDto getDtoFromCsvRecord(CSVRecord csvRecord) {
        var reviewDto = new ReviewDto();
        reviewDto.setId(Long.parseLong(csvRecord.get("Id")));
        reviewDto.setProductId(csvRecord.get("ProductId"));
        reviewDto.setUserId(csvRecord.get("UserId"));
        reviewDto.setProfileName(csvRecord.get("ProfileName"));
        reviewDto.setHelpfulnessNumerator(Integer
                .parseInt(csvRecord.get("HelpfulnessNumerator")));
        reviewDto.setHelpfulnessDenominator(Integer
                .parseInt(csvRecord.get("HelpfulnessDenominator")));
        reviewDto.setScore(Integer.parseInt(csvRecord.get("Score")));
        reviewDto.setTime(convertToLocalDateTime(csvRecord.get("Time")));
        reviewDto.setSummary(csvRecord.get("Summary"));
        reviewDto.setText(csvRecord.get("Text"));
        return reviewDto;
    }

    public Review getReviewFromReviewDto(ReviewDto reviewDto) {
        var review = new Review();
        review.setText(reviewDto.getText());
        review.setSummary(reviewDto.getSummary());
        review.setTime(reviewDto.getTime());
        review.setScore(reviewDto.getScore());
        review.setHelpfulnessNumerator(reviewDto.getHelpfulnessNumerator());
        review.setHelpfulnessDenominator(reviewDto.getHelpfulnessDenominator());
        var product = new Product();
        product.setId(reviewDto.getProductId());
        review.setProduct(product);
        var user = new User();
        user.setId(reviewDto.getUserId());
        user.setProfileName(reviewDto.getProfileName());
        review.setUser(user);
        return review;
    }

    private LocalDateTime convertToLocalDateTime(String time) {
        var instant = Instant.ofEpochMilli(Long.parseLong(time));
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}

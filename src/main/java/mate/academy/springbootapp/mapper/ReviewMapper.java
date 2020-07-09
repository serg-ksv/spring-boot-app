package mate.academy.springbootapp.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import mate.academy.springbootapp.dto.ReviewDto;
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

    private LocalDateTime convertToLocalDateTime(String time) {
        var instant = Instant.ofEpochMilli(Long.parseLong(time));
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}

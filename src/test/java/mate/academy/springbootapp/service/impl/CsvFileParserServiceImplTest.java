package mate.academy.springbootapp.service.impl;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import mate.academy.springbootapp.dto.ReviewDto;
import mate.academy.springbootapp.mapper.ReviewMapper;
import mate.academy.springbootapp.service.FileParserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CsvFileParserServiceImplTest {
    private static final String FILEPATH = "src/test/resources/reviews-test.csv";
    private FileParserService csvFileParserService;

    @Before
    public void setUp() {
        csvFileParserService = new CsvFileParserServiceImpl(new ReviewMapper());
    }

    @Test
    public void parseCsvFileOk() {
        var reviewDto1 = new ReviewDto();
        reviewDto1.setId(1L);
        reviewDto1.setProductId("B001E4KFG0");
        reviewDto1.setUserId("A3SGXH7AUHU8GW");
        reviewDto1.setProfileName("delmartian");
        reviewDto1.setHelpfulnessNumerator(1);
        reviewDto1.setHelpfulnessDenominator(1);
        reviewDto1.setScore(5);
        var time1 = Instant.ofEpochMilli(1303862400)
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        reviewDto1.setTime(time1);
        reviewDto1.setSummary("Good Quality Dog Food");
        reviewDto1.setText("Sample text in the first review.");
        var reviewDto2 = new ReviewDto();
        reviewDto2.setId(2L);
        reviewDto2.setProductId("B00813GRG4");
        reviewDto2.setUserId("A1D87F6ZCVE5NK");
        reviewDto2.setProfileName("dll pa");
        reviewDto2.setHelpfulnessNumerator(0);
        reviewDto2.setHelpfulnessDenominator(0);
        reviewDto2.setScore(1);
        var time2 = Instant.ofEpochMilli(1346976000)
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        reviewDto2.setTime(time2);
        reviewDto2.setSummary("Not as Advertised");
        reviewDto2.setText("Sample text in the second review.");

        List<ReviewDto> expected = List.of(reviewDto1, reviewDto2);
        List<ReviewDto> actual = csvFileParserService.parseCsvFile(FILEPATH);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FileNotFoundException.class)
    public void parseCsvFileWrongPath() {
        String pathFile = "src/test/wrong-path/reviews-test.csv";
        csvFileParserService.parseCsvFile(pathFile);
    }

    @Test(expected = NullPointerException.class)
    public void parseCsvFileNullValue() {
        csvFileParserService.parseCsvFile(null);
    }
}

package mate.academy.springbootapp.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import mate.academy.springbootapp.model.dto.ReviewDto;
import mate.academy.springbootapp.model.mapper.ReviewMapper;
import mate.academy.springbootapp.service.FileParserService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CsvFileParserServiceImpl implements FileParserService {
    private final ReviewMapper reviewMapper;

    @SneakyThrows(IOException.class)
    @Override
    public List<ReviewDto> parseCsvFile(String filePath) {
        var reader = new FileReader(new File(filePath));
        var csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (var csvRecord : csvParser) {
            var reviewDto = reviewMapper.getDtoFromCsvRecord(csvRecord);
            reviewDtoList.add(reviewDto);
        }
        return reviewDtoList;
    }
}

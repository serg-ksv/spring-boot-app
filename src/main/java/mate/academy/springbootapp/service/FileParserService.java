package mate.academy.springbootapp.service;

import java.util.List;
import mate.academy.springbootapp.dto.ReviewDto;

public interface FileParserService {
    List<ReviewDto> parseCsvFile(String filePath);
}

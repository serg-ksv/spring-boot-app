package mate.academy.springbootapp.service;

import java.util.List;

public interface FileService {
    List<String> readFile(String filePath);
}

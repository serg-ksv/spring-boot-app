package mate.academy.springbootapp.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.springbootapp.service.FileService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    public List<String> readFile(String filePath) {
        Path path = Paths.get(filePath);
        if (Files.notExists(path)) {
            throw new IllegalArgumentException("There is no such file.");
        }
        List<String> list;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            list = reader.lines().collect(Collectors.toList());
            return list;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}

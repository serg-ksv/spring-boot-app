package mate.academy.springbootapp.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import mate.academy.springbootapp.service.FileService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileServiceImplTest {
    private static final String FILEPATH = "src/test/resources/test.txt";
    private FileService fileService;

    @Before
    public void setUp() {
        fileService = new FileServiceImpl();
    }

    @Test
    public void readFileRelativePath() {
        Path path = Paths.get(FILEPATH);
        Assert.assertTrue(Files.exists(path));
    }

    @Test
    public void readFileOk() {
        List<String> expected = List.of("Some random text", "for testing");
        List<String> actual = fileService.readFile(FILEPATH);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readFileWrongPath() {
        String pathFile = "src/test/wrong-path/test.txt";
        fileService.readFile(pathFile);
    }

    @Test(expected = NullPointerException.class)
    public void readFileNullValue() {
        fileService.readFile(null);
    }
}

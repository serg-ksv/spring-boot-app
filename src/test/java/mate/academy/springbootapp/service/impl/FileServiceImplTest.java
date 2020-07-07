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
    private static final String FILEPATH = "src/test/resources/test.csv";
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
        String line1 = "Id,ProductId,UserId,ProfileName";
        String line2 = "HelpfulnessNumerator,HelpfulnessDenominator,Score,Time,Summary,Text";
        List<String> expected = List.of(line1, line2);
        List<String> actual = fileService.readFile(FILEPATH);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readFileWrongPath() {
        String pathFile = "src/test/wrong-path/test.csv";
        fileService.readFile(pathFile);
    }

    @Test(expected = NullPointerException.class)
    public void readFileNullValue() {
        fileService.readFile(null);
    }
}

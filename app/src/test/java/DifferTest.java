import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static hexlet.code.Differ.generate;

public class DifferTest {
    private static String expectedResultStylish;
    private static String expectedResultJson;
    private static String expectedResultPlain;

    public static Path getAbsolutePath(String fileName) {
        return Paths.get("./src/test/resources/fixtures/", fileName).toAbsolutePath().normalize();
    }

    public static String readFile(String fileName) throws IOException {
        return Files.readString(getAbsolutePath(fileName)).trim();
    }
    @BeforeAll
    public static void setup() throws IOException {
        expectedResultStylish = readFile("stylish.txt").replace("\r", "");
        expectedResultPlain = readFile("plain.txt").replace("\r", "");
        expectedResultJson = readFile("JSON.json").replace("\r", "");
    }

    @ParameterizedTest
    @ValueSource(strings =  {"json", "yaml"})
    public static void generateTestWihDefaultOutput(String inputFormat) throws Exception {
        String filepath1 = getAbsolutePath("file1." + inputFormat).toString();
        String filepath2 = getAbsolutePath("file2." + inputFormat).toString();

        assertEquals(expectedResultStylish.trim(), generate(filepath1, filepath2));
    }

    @ParameterizedTest
    @ValueSource(strings =  {"json", "yaml"})
    public static void generateTestWihStylishOutput(String inputFormat) throws Exception {
        String filepath1 = getAbsolutePath("file1." + inputFormat).toString();
        String filepath2 = getAbsolutePath("file2." + inputFormat).toString();

        assertEquals(expectedResultStylish, generate(filepath1, filepath2, "stylish"));
    }

    @ParameterizedTest
    @ValueSource(strings =  {"json", "yaml"})
    public static void generateTestWihPlainOutput(String inputFormat) throws Exception {
        String filepath1 = getAbsolutePath("file1." + inputFormat).toString();
        String filepath2 = getAbsolutePath("file2." + inputFormat).toString();

        assertEquals(expectedResultPlain, generate(filepath1, filepath2, "plain"));
    }

    @ParameterizedTest
    @ValueSource(strings =  {"json", "yaml"})
    public static void generateTestWihJsonOutput(String inputFormat) throws Exception {
        String filepath1 = getAbsolutePath("file1." + inputFormat).toString();
        String filepath2 = getAbsolutePath("file2." + inputFormat).toString();

        assertEquals(expectedResultJson, generate(filepath1, filepath2, "json"));
    }
}

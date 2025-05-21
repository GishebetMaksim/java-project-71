import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static hexlet.code.Differ.generate;

public class DifferTest {

    @Test
    public void generateTest() throws Exception {
        String expectedString = "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true";

        String filepath1 = Paths.get("file1.json").toString();
        String filepath2 = Paths.get("file2.json").toString();

        assertEquals(expectedString, generate(filepath1, filepath2));
    }
}

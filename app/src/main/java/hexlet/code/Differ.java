package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String file1Content = readFile(filePath1);
        String file2Content = readFile(filePath2);

        String file1Format = fileFormat(filePath1);
        String file2Format = fileFormat(filePath2);

        Map<String, Object> map1 = Parser.parseToMap(file1Content, file1Format);
        Map<String, Object> map2 = Parser.parseToMap(file2Content, file2Format);

        var diff = Comparer.compare(map1, map2);

        return Formatter.formatting(format, diff);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    static String readFile(String filepath) throws IOException {
        return Files.readString(Path.of(filepath));
    }

    static String fileFormat(String filepath) throws Exception {
        String format;
        int lastDotIndex = filepath.lastIndexOf('.');
        if (lastDotIndex == -1) {
            format = "";
        } else {
            format = filepath.substring(lastDotIndex);
        }
        return format;
    }
}

package hexlet.code.formatters;

import hexlet.code.CompareResult;
import java.util.List;

public class Formatter {
    public static String formatting(String format, List<CompareResult> diff) throws Exception {
        return switch (format) {
            case ("stylish") -> StylishFormatter.stylish(diff);
            case ("plain") -> PlainFormatter.plain(diff);
            case("json") -> JSONFormatter.jsonFormat(diff);
            default -> throw new Exception("Unknown format: " + format);
        };
    }
}

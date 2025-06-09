package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatting(String format, List<Map<String, Object>> diff) throws Exception {
        return switch (format) {
            case ("stylish") -> StylishFormatter.stylish(diff);
            case ("plain") -> PlainFormatter.plain(diff);
            case("json") -> JSONFormatter.jsonFormat(diff);
            default -> throw new Exception("Unknown format.");
        };
    }
}

package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parseToMap(String data, String format) throws Exception {
        ObjectMapper mapper;
        if (format.equals(".yaml") || format.equals(".yml")) {
            mapper = new ObjectMapper(new YAMLFactory());
        } else if (format.equals(".json")) {
            mapper = new ObjectMapper(); // JSON по умолчанию
        } else {
            throw new IllegalArgumentException("Unknown format: " + format);
        }

        return mapper.readValue(data, new TypeReference<Map<String, Object>>() { });
    }
}

package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parseToMap(String fileContent, String fileFormat) throws Exception {
        ObjectMapper mapper;
        if (fileFormat.equals(".yaml") || fileFormat.equals(".yml")) {
            mapper = new ObjectMapper(new YAMLFactory());
        } else if (fileFormat.equals(".json")) {
            mapper = new ObjectMapper(); // JSON по умолчанию
        } else {
            throw new IllegalArgumentException("Unknown file format: " + fileFormat);
        }

        return mapper.readValue(fileContent, new TypeReference<Map<String, Object>>() { });
    }
}

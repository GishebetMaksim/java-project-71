package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONFormatter {
    public static String jsonFormat(List<Map<String, Object>> diff) throws JsonProcessingException {
        var firstMapToJson = "";
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> strings = new ArrayList<>();
        firstMapToJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(diff);
        return firstMapToJson;
    }
}

package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.CompareResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONFormatter {
    public static String jsonFormat(List<CompareResult> diff) throws JsonProcessingException {
        var diffToJson = "";
        ObjectMapper objectMapper = new ObjectMapper();
        diffToJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(diff);
        return diffToJson;
    }
}

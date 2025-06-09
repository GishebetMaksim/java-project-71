package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String plain(List<Map<String, Object>> diff) throws Exception {
        var resultStringsList = new ArrayList<String>() { };

        for (var map: diff) {
            String status = (String) map.get("status");

            switch (status) {
                case "unchanged":
                    break;
                case "updated":
                    resultStringsList.add("Property '" + map.get("key") + "' was updated. From "
                            + outputType(map, "old value") + " to " + outputType(map, "new value"));
                    break;
                case "added":
                    resultStringsList.add("Property '" + map.get("key") + "' was added with value: "
                            +  outputType(map, "new value"));
                    break;
                case "removed":
                    resultStringsList.add("Property '" + map.get("key") + "' was removed");
                    break;
                default:
                    throw new Exception("Unknown state.");
            }
        }

        return String.join("\n", resultStringsList);
    }

    private static String outputType(Map<String, Object> map, String key) {
        if (map.get(key) == null) {
            return "null";
        }
        if (map.get(key) instanceof List || map.get(key) instanceof Map) {
            return "[complex value]";
        } else if (map.get(key) instanceof String) {
            return "'" + map.get(key).toString() + "'";
        } else {
            return map.get(key).toString();
        }
    }
}

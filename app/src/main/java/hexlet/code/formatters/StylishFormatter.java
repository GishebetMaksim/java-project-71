package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String stylish(List<Map<String, Object>> diff) throws Exception {
        var resultStringsList = new ArrayList<String>() { };
        resultStringsList.add("{");
        for (var map: diff) {
            String status = (String) map.get("status");

            switch (status) {
                case "unchanged":
                    resultStringsList.add("    " + map.get("key") + ": " + map.get("old value"));
                    break;
                case "updated":
                    resultStringsList.add("  - " + map.get("key") + ": " + map.get("old value"));
                    resultStringsList.add("  + " + map.get("key") + ": " + map.get("new value"));
                    break;
                case "added":
                    resultStringsList.add("  + " + map.get("key") + ": " + map.get("new value"));
                    break;
                case "removed":
                    resultStringsList.add("  - " + map.get("key") + ": " + map.get("old value"));
                    break;
                default:
                    throw new Exception("Unknown state.");
            }
        }
        resultStringsList.add("}");

        return String.join("\n", resultStringsList);
    }
}

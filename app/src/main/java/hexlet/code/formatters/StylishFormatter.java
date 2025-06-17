package hexlet.code.formatters;

import hexlet.code.CompareResult;
import hexlet.code.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String stylish(List<CompareResult> diff) throws Exception {
        var resultStringsList = new ArrayList<String>() { };
        resultStringsList.add("{");
        for (var compareResult: diff) {
            Status status = compareResult.getStatus();

            switch (status) {
                case Status.unchanged:
                    resultStringsList.add("    " + compareResult.getKey() + ": " + compareResult.getOldValue());
                    break;
                case Status.updated:
                    resultStringsList.add("  - " + compareResult.getKey() + ": " + compareResult.getOldValue());
                    resultStringsList.add("  + " + compareResult.getKey() + ": " + compareResult.getNewValue());
                    break;
                case Status.added:
                    resultStringsList.add("  + " + compareResult.getKey() + ": " + compareResult.getNewValue());
                    break;
                case Status.removed:
                    resultStringsList.add("  - " + compareResult.getKey() + ": " + compareResult.getOldValue());
                    break;
                default:
                    throw new Exception("Unknown state: " + status);
            }
        }
        resultStringsList.add("}");

        return String.join("\n", resultStringsList);
    }
}

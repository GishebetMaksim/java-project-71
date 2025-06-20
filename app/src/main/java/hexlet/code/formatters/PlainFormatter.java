package hexlet.code.formatters;

import hexlet.code.CompareResult;
import hexlet.code.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String plain(List<CompareResult> diff) throws Exception {
        var resultStringsList = new ArrayList<String>() { };

        for (var compareResult: diff) {
            Status status = compareResult.getStatus();

            switch (status) {
                case Status.unchanged:
                    break;
                case Status.updated:
                    resultStringsList.add("Property '" + compareResult.getKey() + "' was updated. From "
                            + outputType(compareResult.getOldValue()) + " to "
                            + outputType(compareResult.getNewValue()));
                    break;
                case Status.added:
                    resultStringsList.add("Property '" + compareResult.getKey() + "' was added with value: "
                            +  outputType(compareResult.getNewValue()));
                    break;
                case Status.removed:
                    resultStringsList.add("Property '" + compareResult.getKey() + "' was removed");
                    break;
                default:
                    throw new Exception("Unknown state: " + status);
            }
        }

        return String.join("\n", resultStringsList);
    }

    private static String outputType(Object object) {
        if (object == null) {
            return "null";
        } else if (object instanceof List || object instanceof Map) {
            return "[complex value]";
        } else if (object instanceof String) {
            return "'" + object.toString() + "'";
        } else {
            return object.toString();
        }
    }
}

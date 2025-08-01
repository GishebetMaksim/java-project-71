package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Objects;


public class Comparer {

    public static List<CompareResult> compare(Map<String, Object> map1, Map<String, Object> map2) {

        var result = new ArrayList<CompareResult>();

        var keys = new TreeSet<String>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        for (var key: keys) {
            var value1 = map1.get(key);
            var value2 = map2.get(key);

            CompareResult compareResult;

            if (!map2.containsKey(key)) {
                compareResult = new CompareResult(key, value1, "", Status.removed);
            } else if (!map1.containsKey(key)) {
                compareResult = new CompareResult(key, "", value2, Status.added);
            } else if (Objects.equals(value1, value2)) {
                compareResult = new CompareResult(key, value1, value2, Status.unchanged);
            } else {
                compareResult = new CompareResult(key, value1, value2, Status.updated);
            }
            result.add(compareResult);
        }
        return result;
    }
}

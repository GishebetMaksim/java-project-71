package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.HashMap;

public class Comparer {

    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {
        var result = new ArrayList<Map<String, Object>>();
        var keys = new TreeSet<String>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());
        for (var key: keys) {
            var value1 = file1.get(key);
            var value2 = file2.get(key);
            var diff = new HashMap<String, Object>();
            diff.put("key", key);
            if (!file2.containsKey(key)) {
                diff.put("status", "removed");
                diff.put("old value", value1);
            } else if (!file1.containsKey(key)) {
                diff.put("status", "added");
                diff.put("new value", value2);
            } else if (compareObjects(value1, value2)) {
                diff.put("status", "unchanged");
                diff.put("old value", value1);
            } else {
                diff.put("status", "updated");
                diff.put("old value", value1);
                diff.put("new value", value2);
            }
            result.add(diff);
        }
        return result;
    }

    static boolean compareObjects(Object obj1, Object obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        }
        if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }
}

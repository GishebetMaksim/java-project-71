package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Differ {
    public static  String generate(String filePath1, String filePath2) throws Exception {
        //System.out.println(filePath1);

        Map<String, String> map1 = jsonToMap(filePath1);
        Map<String, String> map2 = jsonToMap(filePath2);

        var strings = new ArrayList<String>();

        var entries1 = map1.entrySet();
        var entries2 = map2.entrySet();

        for (var entry1: entries1) {
            var key = entry1.getKey();
            var value = entry1.getValue();

            if (map2.containsKey(key)) {  // ключ из первого словаря есть во втором словаре
                if (value.equals(map2.get(key))) {  // a) их значения совпадают
                    strings.add(key + ": " + value + "  ");
                } else { // б) их значения не совпадают
                    strings.add(key + ": " + value + "- ");
                    strings.add(key + ": " + map2.get(key) + "+ ");
                }
            } else {  // ключа из первого словаря нет во втором словаре
                strings.add(key + ": " + value + "- ");
            }
        }

        for (var entry2: entries2) {
            var key = entry2.getKey();
            var value = entry2.getValue();

            if (!map1.containsKey(key)) { // ключа из второго словаря нет в первом словаре
                strings.add(key + ": " + value + "+ ");
            }
        }

        Collections.sort(strings);

        // При изменении значения в паре ключ-значение, первым идет пара из первого файла, которая записана
        // со знаком минус
        for (int i = 1; i < strings.size(); i++) {
            String currentString = strings.get(i);
            String lastString = strings.get(i - 1);

            var s = currentString.split("");
            if (currentString.split(":")[0].equals(lastString.split(":")[0])) {
                if (currentString.split("")[currentString.length() - 2].equals("-")) {
                    strings.set(i, lastString);
                    strings.set(i - 1, currentString);
                }
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            String newString = str.substring(str.length() - 2) + str.substring(0, str.length() - 2);
            strings.set(i, newString);
        }

        return String.join("\n", strings);
    }


    private static Map<String, String> jsonToMap(String filepath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String jsonContent = new String(Files.readAllBytes(Paths.get(filepath)));

        return mapper
                .readValue(jsonContent, new TypeReference<Map<String, String>>() { });
    }
}

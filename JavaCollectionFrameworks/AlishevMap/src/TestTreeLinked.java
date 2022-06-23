import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeLinked {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();   //не сохраняет порядок
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();    //сохраняет порядок по мере их добавления
        Map<Integer, String> treeMap = new TreeMap<>();   //сохраняет порядок по значению - если целые числа то понятно с меньшего на большее, если остальное - по есественному порядку ( обьяснится далее)

        testMap(hashMap);
        testMap(linkedHashMap);
        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(12, "Вова");
        map.put(25, "Дима");
        map.put(380, "Егор");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}



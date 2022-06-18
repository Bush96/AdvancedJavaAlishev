import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");

        System.out.println(map);
/*
        map.put(1, "Уже не один");         //при добавлении нового ключа, старое значнеие переписывается на новое, дубликатов быть не может
        System.out.println(map);
        System.out.println(map.get(2));

 */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {      //способ добраться до каждого элемента ключ-значение
            System.out.println(entry.getKey() + entry.getValue());    //класс Entry в джава - и есть эта пара
        }

    }
}

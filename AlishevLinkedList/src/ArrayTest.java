import java.util.ArrayList;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < arrayList.size(); i++) {   //способ вывода содержимого
            System.out.println(arrayList.get(i));
        }

        for (Integer x: arrayList){          //второй способ с ич азер
            System.out.println(x);
        }
    }
}

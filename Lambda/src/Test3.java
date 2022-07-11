import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {

    //задача - умножить каждый элемент списков на два и вернуть значения
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));


        //способ без лямбды:
        for (int i = 0; i < 10; i++) {
            arr[i] = arr[i] * 2;
            list.set(i, list.get(i) * 2);
        }

        //способ с лямбдой:
        arr = Arrays.stream(arr).map(a -> a * 2).toArray();              //Arrays.stream - никак не связано с потоками, это отноится лишь к лямбде
                       // toArray(); - ничего важного, тупо запомнить (преобразование потока обратно в массив
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());        //та же фигня

        System.out.println(list);
        System.out.println(Arrays.toString(arr));
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = (i + 1);
        }
    }
}

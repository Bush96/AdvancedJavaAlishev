import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Test4 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);


        //map.method
        arr = stream(arr).map(a -> a * 2).toArray();
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());

        arr = stream(arr).map(a -> 3).toArray();     //все элементы станут 3ой
        arr = stream(arr).map(a -> a + 1).toArray();      //все запоминается и становится 4 потому что +1


        //filter method
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        arr2 = stream(arr2).filter(a -> a % 2 == 0).toArray();             // filter - фильтрует числа по условию.  a -> a % 2 == 0 - только четные
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        fillArr(arr2);
        fillList(list2);


        //forEach method
        stream(arr2).forEach(System.out::println);      //перебор каждого элемента и действия с ними
        list2.forEach(System.out::println);


        //reduce (берет набор данных и сжимает их в один элемент)
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArr(arr3);
        fillList(list3);

        // асс - аккумулятор (по умолчанию первое значение массива) если ине предусмотрено другое
        // b - текущее значение


        int sum1 = stream(arr3).reduce((acc, b) -> acc + b).getAsInt();    //getAsInt(); - берет результат и преобразовывает в определенную переменную
        int sum2 = list3.stream().reduce((acc, b) -> acc * b).get();

        System.out.println(sum1);
        System.out.println(sum2);


        //в одной лямбде можно юзать несколько методов:

        int[] arr4 = new int[10];
        fillArr(arr4);

        int[] sumsum = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();     //о как дядя
        System.out.println(Arrays.toString(sumsum));



    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }
}

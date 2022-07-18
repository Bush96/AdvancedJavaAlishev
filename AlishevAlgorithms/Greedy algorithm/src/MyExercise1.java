import java.util.*;

public class MyExercise1 {
    public static void main(String[] args) {

        List<Integer> arr = new LinkedList<>();
        arr.add(3);
        arr.add(1);
        arr.add(7);
        arr.add(9);
        arr.add(9);
        arr.add(5);

        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 > o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(arr.toString());
    }
}







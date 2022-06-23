import java.util.HashSet;
import java.util.Set;


//Конспект ст 34
public class Test {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();

        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        Set<Integer> set2 = new HashSet<>();

        set2.add(3);
        set2.add(6);
        set2.add(2);
        set2.add(7);
        set2.add(8);

        // Union - обьединение множеств
        Set<Integer> union = new HashSet<>(set1);
        set1.addAll(set2);
        System.out.println(union);

        //Intersection - пересечение множеств
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);   //retainAll - оставляет только ту инфу которая была передана аргументом. т е тут set2

        //diference - разность множеств
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);  //Удаляет элементы которые передаются в виде аргумента
    }
}

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String a = "Hello there hey";
        String[] words = a.split(" ");         //способ разделения строки по пробелам и занесения этого в массив
        System.out.println(Arrays.toString(words));

        String ab = "Hello there hey";
        String[] wordsab = a.split("\\.");         //способ разделения строки по точкам и занесения этого в массив
        System.out.println(Arrays.toString(wordsab));

        String b = "Hello123234there3425324hey";
        String[] wordsb = a.split("\\d+");         //способ разделения строки по множествам цифр и занесения этого в массив
        System.out.println(Arrays.toString(wordsb));

        String с = "Hello there hey";
        String[] wordsс = a.split(" ");         //способ разделения строки по пробелам и занесения этого в массив
        System.out.println(Arrays.toString(wordsс));

        String d = "Hello there hey";
        String modifiedString = d.replace(" ", ".");         //способ замены чегото на чтото
        System.out.println(modifiedString);
    }
}

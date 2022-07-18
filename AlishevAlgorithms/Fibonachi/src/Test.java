import java.util.Arrays;

public class Test {
    /*
    public static void main(String[] args) {
        System.out.println(fibEffective(10));

    }

     */

    //медленный очевидный
    private static long fibNaive(int n) {      //супер неудачный способ, так как выполняется куча повторных вычислений
        if (n <= 1)
            return n;

        return fibNaive(n - 1) + fibNaive(n - 2);
    }

    //Эффективный
    private static long fibEffective(int n) {     //жертвуем памятью ради скорости
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    // с использованием мемоизации:
    public static void main(String[] args) {
        int n = 100;   //записываем число фиббоначи которое будем вычислять
        long[] mem = new long[n + 1];

        Arrays.fill(mem, -1);      //fill - заполняет массив переданными значениями

        System.out.println(fibMem(n, mem));
    }

    private static long fibMem(int n, long[] mem) {
        if (mem[n] != -1)
            return mem[n];

        if (n <= 1)
            return n;

        long result = fibMem(n - 1, mem) + fibMem(n - 2, mem);
        mem[n] = result;
        return result;
    }

}

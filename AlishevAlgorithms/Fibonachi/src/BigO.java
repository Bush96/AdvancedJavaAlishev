public class BigO {
    //при подсчете сложности алгоритма по Большому О, рассматриваем только самые быстрорастуще члены выражения
    public static void main(String[] args) {
        System.out.println(fibTry(8));
    }

    public static long fibTry(int n) {
        long[] arr1 = new long[n + 1];    //О(n)
        arr1[0] = 0;  //O(1)
        arr1[1] = 1;  //O(1)

        for (int i = 2; i <= n; i++) {
            arr1[i] = arr1[i - 1] + arr1[i - 2];   //O(n)
        }
        return arr1[n];    //O(1)
    }

}

//Итого: O(n) + O(1) + O(1) + O(n) + O(1) = O(2n + 3) = O(n)
//Вот итоговый результат Большому О, переменная Н самая большая, потому учитываем только ее
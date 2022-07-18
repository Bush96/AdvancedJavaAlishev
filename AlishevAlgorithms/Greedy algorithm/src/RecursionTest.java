public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(recursion(4));
        //что есть фрактал:
        //4! = 4*3*2*1
        //1! = 1
        //15! = 14*13*12*...*1
        //0!=1
    }

    //как работает рекурсия на фракталах:
    //4*rec(3)
    //3*rec(2)
    //2*rec(1)
    //rec(1) = return 1

    //сперва все считается сверху вниз, когда доходит до конца, все считется в обратную сторону:

    //rec(1) = 1, значит далее будет 2*1=2, далее 3*2=6, далее 4*6=24, это и есть ответ.

    public static int recursion(int n) {
        if (n == 1)
            return 1;
        return n * recursion(n - 1);
    }
}

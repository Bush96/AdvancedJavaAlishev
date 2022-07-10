public class Test {
    public static void main(String[] args) {
        /*  (о цифрах)
        \\d - одна цирфа
        \\w - одна английская буква
        + - 1 или более
        * - 0 или более
        ?  - 0 или 1 символов до
        (x|y) - одна строка из множества строк

        (о буквах и цифрах)
        [a-zA-Z] -  опишем все английские буквы
        [0-9]  - \\d
        [^abc] -  хотим в тру все символы кроме этих

        . - любой символ

        {2} - 2 символа до (\\d{2}) -хотим на этом месте увидеть 2 цифры
        {2, } - от 2 символа до бесконечности (\\d{2, }) -хотим на этом месте увидеть от 2 цифр до бесконечности
        {2,4} - понятно

         */

        String a = "9";
        System.out.println(a.matches("\\d"));   //true
        String ab = "91";
        System.out.println(ab.matches("\\d"));   //false
        String ac = "123414";
        System.out.println(ac.matches("\\d+"));   //true
        String ad = "-123414";
        System.out.println(ad.matches("-\\d*"));   //true
        String aa = "-123414";
        System.out.println(aa.matches("-?\\d+"));   //true (минусможет быть а может и не быть)
        String aq = "123414";
        System.out.println(aq.matches("(-|\\+)?\\d+"));   //false       (если нужен +, ставим два \\)


        String b = "a234432";
        System.out.println(b.matches("[a-zA-Z]\\d+"));   //true   (поиск всех букв(одной из)
        String bab = "aс234432";
        System.out.println(bab.matches("[a-zA-Z]+\\d+"));   //true  (поиск множетсва, потому то стоит +, как и с цифрами)
        String ba = "aсa23fds4432";
        System.out.println(ba.matches("[a-zA-Z]+\\d+"));    //false   (буквы между цифрами идут в счет, тру не получится так)


        //случай где будет выдаваться тру, если не содержаться определенные символы:
        String c = "hello";
        System.out.println(c.matches("[^e]"));     //false   ( е есть так то фолс)

//любой символ:
        String da = "http://www.google.com";
        System.out.println(da.matches("http://www\\..+\\.(com|ru)"));   //true

        String g = "123";
        System.out.println(g.matches("\\d{2}"));   //false (цифр больше ем две)


    }
}

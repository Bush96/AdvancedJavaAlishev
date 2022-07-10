import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        String text = " sadfsa bfb sdfnng bob@gmail.com n! gfndgd\n " +
                " sadfgag .sa bran@yandex.ru dfg sdggr. g fgdg\n" +
                "dgdsfg fg r t34 f gdsg gt rg ";

        Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");      //так создаем и указываем что ищем
//(\w+) - заключение в группу, его айди 1
        Matcher matcher = email.matcher(text);

        while (matcher.find()) {                 //find- ищет очередное соответствие
            System.out.println(matcher.group(1));
            //group()) - без аргументов ищет все совпадение
            //group(1)) - выведет только (\w+) эту часть
        }

    }
}

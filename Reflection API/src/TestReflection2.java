import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


//можно сказать мы тут пишем глобальный паттерн для работы с различными обьектами по определенному алгоритму, что может только рефлексия
public class TestReflection2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        //Название_класса1 Название_класса2 Название_метода( потому 3 scanner.next())

        Class classObject1 = Class.forName(scanner.next());   //считываем первый обект
        Class classObject2 = Class.forName(scanner.next());   //второй
        String methodName = scanner.next();              //метод

        Method m = classObject1.getMethod(methodName, classObject2);   //метод помещаем в переменную м и по заданию в его аргументы помещаем имя и второй обьект

        Object o1 = classObject1.newInstance();             //так создаем первый обьек который удем считывать
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");        //второй

        m.invoke(o1, o2); //так мы вызываем этот метод на обьекте о1Б с аргументом о2

        System.out.println(o1);

    }
}

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


//суть рефлексии заключается в том чтобы воспринимать экземпляры классов обьектами класса класс
//и работать с нимуже как с обьектом а не как с классом
public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {      //искл к способу номер3
        Person person = new Person();

        Class personClass = Person.class;                   //способы получения классом персон класса класс
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("Person");
/*
        Method[] methods = personClass.getMethods();            //так мы получаем все методы класса
        for (Method method : methods) {
            System.out.println(method.getName() + ", "
                    + method.getReturnType() + ", "
                    + method.getParameterTypes() + ", " + Arrays.toString(method.getParameterTypes()));
        }



        Field[] fields = personClass.getDeclaredFields();                //так получаем все поля класса
        for (Field field : fields) {
            System.out.println(field.getName() + ", " + field.getType());
        }
        */


        Annotation[] annotations = personClass.getAnnotations();                //так получаем необходимые аннотации
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                System.out.println("Yes");
            }
        }


    }
}

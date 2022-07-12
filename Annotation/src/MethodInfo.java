import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)         //тем самымы запрещаем использовать эту аннотацию на всем кроме методов
@Retention(RetentionPolicy.RUNTIME)    //  тем самым эта аннотация будет видно во время выполнения и использования программы
public @interface MethodInfo {
    String author() default "Artemij";    //так делаем если хотим дефолтное поле, но в реализации его все равно можно изменить
    int dateOfCreate();
    String purpose();
}

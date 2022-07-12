import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Vector2DTest {
    @Test
    public void newVectorShoundHaveZeroLenght() {
        Vector2D v1 = new Vector2D();   //action

        //assertion
        // 1e-0 = 0.0000000001
        Assert.assertEquals(0,v1.lenght(), 1e-9);     //0,v1.lenght(), 1e-9);  что ожидаем, реальный результат и точность с которой мы хотим чтоб прошло совпадение
    }

}

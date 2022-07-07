import java.util.Random;
import java.util.concurrent.*;

import static sun.swing.SwingUtilities2.submit;

public class CallableFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(() -> {        //ипользуя future мы ожидаем что после выполнения всего этого потока на выоде мы получим переменную Integer
            System.out.println("Start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish");
            Random random = new Random();
            int randomValue = random.nextInt();

            if (randomValue < 5) {
                throw new Exception("Something bad happend");
            }      //используя Future мы можем обьявлять исключения

            return random.nextInt(10);      //при ранбл такого бы не получилось
        });

        executorService.shutdown();

        try {
            int result = future.get();   //get дожидается окончания выполненния потока
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {         //а таким образом мы можем наше исключения обрабатывать
            Throwable ex = e.getCause();                   //
            System.out.println(ex.getMessage());       //
        }
    }
}

/*   ПРИМЕР С CALLABLE
 executorService.submit((Callable<Integer>) () -> {        //юзаем вместо Runnable Callable чтобы метод мог возвращать какие то значения
        System.out.println("Start");
        try {
        Thread.sleep(3000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        System.out.println("Finish");
        Random random = new Random();
        return random.nextInt(10);      //при ранбл такого бы не получилось
        });

        executorService.shutdown();


 */
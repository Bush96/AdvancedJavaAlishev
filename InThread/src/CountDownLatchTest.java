import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);    //Декриминтирует переменную на число переданное в аргумент

        ExecutorService executorService = Executors.newFixedThreadPool(3);   //пул потоков

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch));   //передаем потокам задания
        }
        executorService.shutdown();     //в конц еобязательно выклчаем

        countDownLatch.await();     //методна котором ожидается окончание счетчика
        System.out.println("Latch has been opened, main thread is processing");    //только когда другие потоки 3 раза отработаются, программа возворащается сюда и продолжает работу
    }
}

class Processor implements Runnable {
    private CountDownLatch countDownLatch;     //обьявляем в классе  класс счетчик

    public Processor(CountDownLatch countDownLatch) {     //передаем его в параметры
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();         //запускаем счетчик
    }
}
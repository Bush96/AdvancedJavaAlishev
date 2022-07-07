import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);   //так создаем пул потоков

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));   //так мы передаем потокам задания для выполнения

            executorService.shutdown();        //это чтото вроде start
            System.out.println("All tasks submitted");

            executorService.awaitTermination(1, TimeUnit.DAYS);   //чтото вроде join, указываем время на выполнение работы

        }
    }
}


class Work implements Runnable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " was completed");
    }
}


//способо при котором потоки не нужно создавать в ручную 22
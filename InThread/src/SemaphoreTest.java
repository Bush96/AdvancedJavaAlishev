import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        Connection connection = Connection.getConnection();     //так мы вызываем наш приватный коннекшн
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {      //создаем анонимный класс
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

}

//Singleton
class Connection {
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {       //таким образом мы не даем создавать другие обьекты эттого класса

    }

    public static Connection getConnection() {      //
        return connection;                          //
    }

    public void work() throws InterruptedException {   //здесь мы завязываем тот факт что лишь 10 потоков параллельно выполняют работу, остальные ждут своей оереди
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }

    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println(connectionsCount);
        }
        Thread.sleep(5000);

        synchronized (this) {
            connectionsCount--;
        }
    }
}



 /*
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);       //в аргументы перредается число, сколько потоков одновременно имеют доступ к ресурсу

        semaphore.release();     //отдает разрешение когда в потоке заканчиваем использовать ресурс
        try {
            semaphore.acquire();      //когда в потоке наинаем взаимодействовать с ресурсом
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(semaphore.availablePermits());     //выбрасывает количество разрешений котороые еще свободны
    }
    //часть первого ознакомления!!
     */
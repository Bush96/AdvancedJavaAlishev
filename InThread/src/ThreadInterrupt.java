import java.util.Random;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000; i++) {
                    if (Thread.currentThread().isInterrupted()) {         //выражение, при котором поток остановится, когда программа прочитаем метод interrupt
                        System.out.println("Thread was interrupted");
                        break;
                    }

                    Math.sin(random.nextDouble());
                }
            }
        });

        System.out.println("Thread start");

        thread.start();

        Thread.sleep(1000);
        thread.interrupt();     //метод говорящий что какойто поток будет остановлен

        thread.join();

        System.out.println("Thread was finish");
    }
}

//все идентично, но интерпут у меня тут не срабатывает
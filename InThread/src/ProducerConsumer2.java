import java.util.LinkedList;
import java.util.Queue;


public class ProducerConsumer2 {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer1 pc = new ProducerConsumer1();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}

class ProducerConsumer1 {
    private Queue<Integer> queue = new LinkedList<>();     //реализуем паттерн без помощи готовых классов, создаем пока несинхранизированную очередь
    private final int LIMIT = 10;       //указываем максимальное количество в очереди
    private final Object lock = new Object();   //создаем обьект для синхронизации и передачи монитроов

    public void producer() throws InterruptedException {
        int value = 0;

        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) {
                    lock.wait();
                }

                queue.offer(value++);
                lock.notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size is " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}


//wait, notify - стандартные метоы джава для синхронизации потоков

//создаем паттерн паттер продюсер консюмер без использования готовых джава классов, а сами на более низкмо уровне программирования
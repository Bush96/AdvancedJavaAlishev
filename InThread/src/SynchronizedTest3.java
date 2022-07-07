import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedTest3 {
    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }
}

class Worker {
    Random random = new Random();      //генерируем случайные числа

    Object lock1 = new Object();      //создаем обьекты которые будут отвечать только за синхранизацию отдельных обьектов в потоках
    Object lock2 = new Object();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
        synchronized (lock1) {   //оформляя синхронизацию так мы ускоряем работу программы позволяя разным потокам не ждать оконания работы другогоБ а приступить к выполнению другого свободного блока
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                list1.add(random.nextInt(100));

            }
        }
    }

    public void addToList2() {
        synchronized (lock2) {       //
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();

                }
                list2.add(random.nextInt(100));
            }
        }
    }

    public void work() {
        addToList1();
        addToList2();
    }

    public void main() {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();
        System.out.println("Program took " + (after - before) + " ms to run");

        System.out.println("List1 " + list1.size());
        System.out.println("List2 " + list2.size());
    }
}


//не возникает гонки
//ускоряем время работы
//стабильный результат
//параллельное выполнение
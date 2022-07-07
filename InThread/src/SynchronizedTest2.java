public class SynchronizedTest2 {
    private int counter;

    //конс 39
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        test.doWork();
    }

    public void increment() {
        synchronized (this) {       //2ой способ инхранизации на конкретном обьекте, синхранизированный блок,
            counter++;             //
        }
    }

    //без синхронизации счетчик не все достигал бы суммарного знаения так как потоки дополняли бы его хаотино не взаимодействия друг с другом
    public void doWork() throws InterruptedException {
        Thread thread7 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment();      //вызываем синхранизированный метод
            }
        }
        );
        Thread thread8 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment();
            }
        });
        thread7.start();
        thread8.start();

        thread7.join();
        thread8.join();

        System.out.println(counter);
    }
}


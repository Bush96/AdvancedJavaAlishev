public class SynchronizedTest {
    private int counter;

    //конс 39
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        test.doWork();
    }

    public synchronized void increment() {        //синхранизирует доступ к методу потокам, один поток может работать с этим методом только когда законил второй
        counter++;
    }

    //без синхронизации счетчик не все достигал бы суммарного знаения так как потоки дополняли бы его хаотино не взаимодействия друг с другом
    public void doWork() throws InterruptedException {
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment();
            }
        }
        );
        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment();
            }
        });
        thread5.start();   //запуск потока
        thread6.start();

        thread5.join();   //ожидаем окончания работы потока чтобы двигаться дальше
        thread6.join();

        System.out.println(counter);
    }
}


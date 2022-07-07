import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);       //а статиеский обект видит только статические методы

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {             //создаем два потока один производит( как этот)
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {        //второй потребляет
            @Override
            public void run() {
                try {
                    consumer();
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

    private static void producer() throws InterruptedException {           //создаем производителя
        Random random = new Random();      //вспоминаем что так рандомятся числа
        //Не забываем что методы статик видят и работают только свой класс

        while (true) {
            queue.put(random.nextInt(100));         //пут помни из главвы о коллекциях, кьюкью имеет такие методы как оффер пут и т.д.
        }
    }

    private static void consumer() throws InterruptedException {

        Thread.sleep(10);    //Указываем как часто мы будем вызывать элемент
        System.out.println(queue.take());            //в патерне тут используем этот вызов, а еще он с исключением т к обьект может и не придти
        System.out.println("Queue size is " + queue.size());

    }
}

import java.util.Scanner;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Test1 test = new Test1();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.consumer();
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

class Test1 {
    public void producer() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started...");
            wait();     //только внутри синх блока
            // 1-отдает Lock обьекта другим потокам, 2- ждет вызова notify на этом обьекте
            System.out.println("Produceer thread resume");     //после срабатывания notify программа возвращается аботать сюда
        }
    }

    public void consumer() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("Waiting for pressed");   //ждем нажатия клавиши
            scanner.nextLine();         //на этом месте программа прекратится и будет ждать пока мы не нажмем ентер
            notify();    //отдаем монитор, т.е. лок обратно тому потоку которым был вызван метод вэйт
        }

    }
}


//wait, notify - стандартные метоы джава для синхронизации потоков

//здесь мы идемк тому чтобы создать паттер продюсер консюмер без использования готовых джава классов, а сами на более низкмо уровне программирования
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();               //так запускаем параллельный поток
        System.out.println("Hello from main");

        myThread.sleep(1000);      //дает можность второму потоку перехватить инициативу


        Thread myThread2 = new Thread(new Runner());   //второй способ
        myThread2.start();

    }
}

class MyThread extends Thread {          //первый способо реализации
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);           //здесь этот метод упорядочивает работу потоков
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from my Thread " + i);
        }
    }
}

class Runner implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);           //здесь этот метод упорядочивает работу потоков
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from my Thread " + i);
        }
    }

}

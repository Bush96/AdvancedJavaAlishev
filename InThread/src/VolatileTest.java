import java.util.Scanner;

public class VolatileTest {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread3.shutdown();
    }
}

class MyThread3 extends Thread {
    private volatile boolean running = true;     //используем ключевое слово чтобы доступ к переменной был согласованным в ситуации когда один поток пишет а другой читаетБ не будет возникать коллизий

    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        this.running = false;
    }
}

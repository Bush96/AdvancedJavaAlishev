import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        Runner1 runner = new Runner1();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}

class Runner1 {
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;
        while (true) {
            try {
                firstLockTaken = lock1.tryLock();     //tryLock() - штука дрюка пытающаяся забрать лок
                secondLockTaken = lock2.tryLock();    //если tryLock() у них полуился, дальше они будут тру а не фолс
            } finally {
                if (firstLockTaken && secondLockTaken) {   //тут если тру тогда возвращаемся в предыдуший метод
                    return;
                }

                if (firstLockTaken) {
                    lock1.unlock();       //если не тру освобождаем лок и даем возможность взять его другому потоку
                }

                if (secondLockTaken) {     //тоже самое
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() {
        Random random = new Random();

        takeLocks(lock1, lock2);      //таким образом мы избегаем ситуации deadlock
        for (int i = 0; i < 10000; i++) {

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();

        takeLocks(lock2, lock1);
        for (int i = 0; i < 10000; i++) {

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance " + (account1.getBalance() + account2.getBalance()));
    }

}

class Account {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}
//смотреть ниже варианты с ошибками


/*
 public void firstThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            lock1.lock();
            ||первый поток здесь
            lock2.lock();
            Account.transfer(account1, account2, random.nextInt(100));
            lock1.unlock();
            lock2.unlock();
        }
    }

    public void secondThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            lock2.lock();
            //и второй поток здесь
            //они ждут друг друга и не дождуться, такая ситуация называется дидлок
            lock1.lock();
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock2.unlock();
                lock1.unlock();                   //unlock всегда юзаем в final локе!
            }
        }
    }
 */


/*
        for (int i = 0; i < 10000; i++) {
synchronized (account1) {
synchronized (account2) {
        Account.transfer(account1, account2, random.nextInt(100));
        }
        }
        }
        }

public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
synchronized (account1) {
synchronized (account2) {
        Account.transfer(account2, account1, random.nextInt(100));
        }
        }


 */

//Такое оформление является не верным, все будет работать но это усложненный вариант
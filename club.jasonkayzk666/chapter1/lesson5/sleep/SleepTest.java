package club.jasonkayzk666.chapter1.lesson5.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SleepTest {

    // 创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();

                try {
                    System.out.println("child threadA is in sleep");

                    Thread.sleep(5000);
                    System.out.println("child threadA is awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("child threadB is in sleep");
                    Thread.sleep(5000);
                    System.out.println("child threadB is awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();

    }

}

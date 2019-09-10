package club.jasonkayzk666.chapter1.lesson9.deadlock;

public class DeadLockDemo {

    // 创建资源
    private static Object sourceA = new Object();
    private static Object sourceB = new Object();

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sourceA) {
                    System.out.println(Thread.currentThread() + " get resourceA");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + " waiting get B");
                    synchronized (sourceB) {
                        System.out.println(Thread.currentThread() + " get B");
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sourceB) {
                    System.out.println(Thread.currentThread() + " get resourceB");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + " waiting get A");
                    synchronized (sourceA) {
                        System.out.println(Thread.currentThread() + " get A");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

    }

}

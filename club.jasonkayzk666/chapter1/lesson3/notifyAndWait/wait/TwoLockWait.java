package club.jasonkayzk666.chapter1.lesson3.notifyAndWait.wait;

public class TwoLockWait {

    // 创建资源
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 获取A的监视器锁
                    synchronized (resourceA) {
                        System.out.println("ThreadA get resourceA lock");
                        // 获取B的监视器锁
                        synchronized (resourceB) {
                            System.out.println("ThreadA get resourceB lock");
                            // 线程A阻塞, 并释放A的锁
                            System.out.println("ThreadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 休眠一秒, 确保ThreadA获取锁
                    Thread.sleep(1000);

                    // 获取A
                    synchronized (resourceA) {
                        System.out.println("ThreadB get resourceA lock");

                        System.out.println("ThreadB try get resourceB lock...");
                        // 获取B的锁
                        synchronized (resourceB) {
                            System.out.println("ThreadB get resourceB lock");

                            // 线程B阻塞, 并释放A的锁
                            System.out.println("ThreadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();

        // 等待两个线程结束
        threadA.join();
        threadB.join();

        System.out.println("main over");
    }
}

package club.jasonkayzk666.chapter1.lesson3.notifyAndWait.wait;

public class WaitAndInterrupted {

    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("--begin--");
                    // 阻塞当前线程
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("--end--");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();

        Thread.sleep(1000);

        System.out.println("--begin interrupt threadA");
        threadA.interrupt();
        System.out.println("--end interrupt threadA");
    }
}

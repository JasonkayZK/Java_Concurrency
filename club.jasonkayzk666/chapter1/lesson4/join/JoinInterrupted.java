package club.jasonkayzk666.chapter1.lesson4.join;

public class JoinInterrupted {

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread-one begin run!");
                for(; ;) {

                }
            }
        });

        // 获取主线程
        final Thread mainThread = Thread.currentThread();

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
            }
        });

        // 启动子线程
        threadOne.start();

        // 延迟一秒启动中断线程
        threadTwo.start();

        // 等待线程one结束
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread: " + e);
        }
    }
}

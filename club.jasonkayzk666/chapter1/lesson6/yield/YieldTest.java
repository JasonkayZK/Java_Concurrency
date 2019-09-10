package club.jasonkayzk666.chapter1.lesson6.yield;

public class YieldTest implements Runnable {

    YieldTest() {
        // 创建并启动线程
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // 当i = 0时, 让出CPU执行权, 放弃时间片, 进行下一论调度
            if (i % 5 ==0) {
                System.out.println(Thread.currentThread() + "yidld cpu...");

                // 当前线程让出CPU执行权, 放弃时间片, 进行下一论调度
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread() + " is over");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}

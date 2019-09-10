package club.jasonkayzk666.chapter1.lesson7.interrupt;

public class InterruptSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread-one begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("thread-one awaking");
                } catch (InterruptedException e) {
                    System.out.println("thread-one is interrupted while sleeping");
                    return;
                }

                System.out.println("thread-one leaving normally");
            }
        });

        threadOne.start();

        Thread.sleep(1000);

        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");
    }
}

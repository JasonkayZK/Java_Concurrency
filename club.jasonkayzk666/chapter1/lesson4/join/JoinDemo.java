package club.jasonkayzk666.chapter1.lesson4.join;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("child thread-one over!");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("child thread-two over!");
            }
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        threadOne.join();
        threadTwo.join();

        System.out.println("all child thread over!");
    }
}

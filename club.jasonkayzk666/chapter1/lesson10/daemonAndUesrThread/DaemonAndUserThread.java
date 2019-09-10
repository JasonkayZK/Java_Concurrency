package club.jasonkayzk666.chapter1.lesson10.daemonAndUesrThread;

public class DaemonAndUserThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        System.out.println("main thread is over!");
    }
}

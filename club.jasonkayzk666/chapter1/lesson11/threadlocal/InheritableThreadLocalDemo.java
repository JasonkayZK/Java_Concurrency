package club.jasonkayzk666.chapter1.lesson11.threadlocal;

public class InheritableThreadLocalDemo {

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        inheritableThreadLocal.set("hello world");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread: " + inheritableThreadLocal.get());
            }
        });

        thread.start();

        System.out.println("main: " + inheritableThreadLocal.get());
    }
}

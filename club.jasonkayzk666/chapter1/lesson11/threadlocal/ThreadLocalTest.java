package club.jasonkayzk666.chapter1.lesson11.threadlocal;

public class ThreadLocalTest {

    public static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void print(String str) {
        // 1. 打印当前线程本地内存中的localVariable变量的值
        System.out.println(str + ": " + localVariable.get());

        // 2. 清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread-one local variable");
                print("thread-one");

                System.out.println("thread-one remove after: " + localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread-two local variable");
                print("thread-two");

                System.out.println("thread-two remove after: " + localVariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();
    }


}

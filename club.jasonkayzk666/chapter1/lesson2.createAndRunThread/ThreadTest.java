package club.jasonkayzk666.chapter1.lesson2.createAndRunThread;

/**
 *  创建线程方法之1: 继承Thread 并重写run()方法
 *
 *
 * */
public class ThreadTest {

    // 继承Thread并重写run()
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread!");
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }

}

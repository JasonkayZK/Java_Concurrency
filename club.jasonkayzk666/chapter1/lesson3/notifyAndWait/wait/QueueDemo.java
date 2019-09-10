package club.jasonkayzk666.chapter1.lesson3.notifyAndWait.wait;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    private static final int MAX_SIZE = 10;
    private static Queue<Integer> queue = new LinkedList<>();


    // 生产者模型
    public static class Producer implements Runnable {

        private int ele;

        public Producer(int ele) {
            this.ele = ele;
        }

        @Override
        public void run() {
            synchronized (queue) {
                // 消费者队列满, 等待队列空闲
                while (queue.size() == MAX_SIZE) {
                    System.out.println("消费者队列已满, 等待中!");
                    try {
                        // 挂起当前线程, 并且释放同步块获取的queue上的锁,
                        // 让消费者可以获取该锁, 然后消费队列元素
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // 空闲时则生成元素, 并通知消费者!
                queue.add(ele);
                queue.notifyAll();
            }
        }
    }

    // 消费者模型
    public static class Consumer implements Runnable {

        @Override
        public void run() {
            synchronized (queue) {

                // 消费者队列为空
                while (queue.size() == 0) {
                    System.out.println("消费者队列为空, 等待中");
                    // 挂起当前线程, 并释放同步锁获取的queue上的监视器锁,
                    // 让生产者可以获取该锁, 将生产元素放入队列
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                // 消费元素, 并通知唤醒生产者线程
                System.out.println(queue.poll());
                queue.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        // 20个生产者
        for (int i = 0; i < 20; ++i) {
            new Thread(new Producer(i)).start();
        }
        // 20个消费者
        for (int i = 0; i < 20; ++i) {
            new Thread(new Consumer()).start();
        }

    }
}

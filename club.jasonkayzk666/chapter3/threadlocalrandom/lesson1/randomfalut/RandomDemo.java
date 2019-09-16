package club.jasonkayzk666.chapter3.threadlocalrandom.lesson1.randomfalut;

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {

        // 生成默认的随机数种子的随机数生成器!
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }

    }
}

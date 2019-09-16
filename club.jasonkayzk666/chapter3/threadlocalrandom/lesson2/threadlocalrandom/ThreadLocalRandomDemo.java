package club.jasonkayzk666.chapter3.threadlocalrandom.lesson2.threadlocalrandom;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomDemo {

    public static void main(String[] args) {
        // 获取一个随机数生成器
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // 输出10个0~5(包括0, 不包括5)之间的随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }

    }

}

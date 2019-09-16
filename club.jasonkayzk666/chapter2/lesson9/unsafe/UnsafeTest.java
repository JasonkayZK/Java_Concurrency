package club.jasonkayzk666.chapter2.lesson9.unsafe;

import sun.misc.Unsafe;

public class UnsafeTest {

    // 获取Unsafe实例
    public static final Unsafe unsafe = Unsafe.getUnsafe();

    // 记录变量state在类UnsafeTest中的偏移值
    public static final long stateOffset;

    // 变量
    private volatile long state = 0;

    static {
        try {
            // 使用Unsafe获取偏移值!
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        // 创建实例, 并设置值为1
        UnsafeTest test = new UnsafeTest();
        System.out.println(unsafe.compareAndSwapLong(test, stateOffset, 0, 1));

    }

}

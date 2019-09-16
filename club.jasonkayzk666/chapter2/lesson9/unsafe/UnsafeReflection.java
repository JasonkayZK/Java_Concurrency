package club.jasonkayzk666.chapter2.lesson9.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeReflection {

    public static Unsafe unsafe;

    public static long stateOffset;

    private volatile long state = 0;

    static {
        try {

            // 使用反射获取Unsafe的成员变量theUnsafe!
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            // 设置为可存取
            field.setAccessible(true);

            // 获取unsafe变量
            unsafe = (Unsafe) field.get(null);

            // 获取偏移量
            stateOffset = unsafe.objectFieldOffset(UnsafeReflection.class.getDeclaredField("state"));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnsafeReflection test = new UnsafeReflection();

        System.out.println(unsafe.compareAndSwapInt(test, stateOffset, 0, 1));
    }

}


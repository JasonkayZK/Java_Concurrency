package club.jasonkayzk666.chapter2.lesson11.fakeshare;

public class FakeShareDemo {

    private static int LINE_NUM = 1024;

    private static int COLUM_NUM = 1024;

    public static void main(String[] args) {
        long[][] fast = new long[LINE_NUM][COLUM_NUM];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; ++i) {
            for (int j = 0; j < COLUM_NUM; ++j) {
                fast[i][j] = i * 2 + j;
            }
        }
        System.out.println("Use Cache time: " + (System.currentTimeMillis() - startTime));

        long[][] slow = new long[LINE_NUM][COLUM_NUM];
        startTime = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; ++i) {
            for (int j = 0; j < COLUM_NUM; ++j) {
                fast[j][i] = i * 2 + j;
            }
        }
        System.out.println("Not use Cache time: " + (System.currentTimeMillis() - startTime));

    }

}

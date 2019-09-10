package club.jasonkayzk666.chapter1.lesson2.createAndRunThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest3 {
    public static class CallerTask implements Callable<String> {


        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

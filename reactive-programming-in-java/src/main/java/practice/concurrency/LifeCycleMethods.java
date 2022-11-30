package practice.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycleMethods {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<100;i++){
            executorService.execute(new Task());
        }


        //initiate shutdown
        executorService.shutdown();;

        //will return true since shutdwon begun
        executorService.isShutdown();

        //will return true if all tasks are completed including queued ones
        executorService.isTerminated();

        executorService.awaitTermination(10, TimeUnit.SECONDS);

        List<Runnable> runnables = executorService.shutdownNow();

    }
    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("Task Class Run Method "+Thread.currentThread().getName());
        }
    }
}

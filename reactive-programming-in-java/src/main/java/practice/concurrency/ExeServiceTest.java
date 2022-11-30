package practice.concurrency;

import java.util.concurrent.*;

public class ExeServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                10,100,120, TimeUnit.SECONDS, new ArrayBlockingQueue<>(300));
        try{
            executorService.execute(new Task());
        }catch(RejectedExecutionException e){
            System.err.println("Task Rejected " + e.getMessage());
        }
    }
    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("Task Class Run Method "+Thread.currentThread().getName());
        }
    }
}

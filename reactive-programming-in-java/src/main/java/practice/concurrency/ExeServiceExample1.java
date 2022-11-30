package practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeServiceExample1 {
    public static void main(String[] args) {
        //create Thread Pool
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //submit the task for execution
        for(int i=0; i<100; i++){
            executorService.execute(new Task());
        }
        System.out.println("Task class Thread Name = "+Thread.currentThread().getName());
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Task class Thread Name = "+Thread.currentThread().getName());
        }
    }
}

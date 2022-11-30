package practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThredPoolExmp {
    public static void main(String[] args) {
        //
        ExecutorService executorService = Executors.newCachedThreadPool();

        //submit the tasks for execution
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

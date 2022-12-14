package practice.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ScheduledExceServiceExmp {
    public static void main(String[] args) {
        //for scheduling of tasks
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        //task to run after 10 second delay
        scheduledExecutorService.schedule(new Task(), 10, SECONDS);

        //task to run repeatedly every 10 seconds
        scheduledExecutorService.scheduleAtFixedRate(new Task(), 15, 10 , SECONDS);

        //task to run repeatedly every 10 seconds after previous task completes
        scheduledExecutorService.scheduleWithFixedDelay(new Task(), 15, 10 , TimeUnit.SECONDS);
    }
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Task class Thread Name = "+Thread.currentThread().getName());
        }
    }
}

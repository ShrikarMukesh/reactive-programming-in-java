package practice.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class FutureExmp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //submit the task for execution
        for(int i=0;i<100;i++){
            Future<Integer> integerFuture = executorService.submit(new Task());
        }

        //perform some unrelated operations
        //1 sec
        for(int i=0;i<100;i++){
            Future<Integer> futue = executorService.submit(new Task());
            try {
                Integer result = futue.get(); //blocking
                System.out.println("Result of future #" + i+ "=" +result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Thead Name: " + Thread.currentThread().getName());
    }
    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}

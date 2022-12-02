package complitable.future;

import java.util.Random;
import java.util.concurrent.*;

public class FutureExmp1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> integerFuture = executorService.submit(new Task());
        try {
            Integer result  = integerFuture.get();
            System.out.println("Result from the task "+ result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}

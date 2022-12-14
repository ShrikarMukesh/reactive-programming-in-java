package practice.concurrency;

//In Java : One Java Thread is Equal to One OS Thread
public class ConcurrencyExmp1 {

    public static void main(String[] args) {
        for(int i =0;i<10;i++) {
            Thread thread1 = new Thread(new Task());
            thread1.start();
        }
        System.out.println("Main Method = "+Thread.currentThread().getName());
    }
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Task class Thread Name = "+Thread.currentThread().getName());
        }
    }
}

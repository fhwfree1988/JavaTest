package Sample.MultiThread.ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {
    //https://www.baeldung.com/thread-pool-java-and-guava
    public static void main(String[] args) {
        //-----------Executor
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Hello World"));

        //----------ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Hello World");
        // some operations
        try {
            String result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //--------------------ThreadPoolExecutor
        ThreadPoolExecutor executor2 =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor2.submit(() -> {
            Thread.sleep(1000);
            return null;
        });

        //assertEquals(2, executor.getPoolSize());
        //assertEquals(1, executor.getQueue().size());


        //-----------------Executors.newSingleThreadExecutor
        AtomicInteger counter = new AtomicInteger();
        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        executor3.submit(() -> {
            counter.set(1);
        });
        executor3.submit(() -> {
            counter.compareAndSet(1, 2);
        });
    }

}

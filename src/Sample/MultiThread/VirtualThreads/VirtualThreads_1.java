package Sample.MultiThread.VirtualThreads;
import Sample.MultiThread.Callable.MyCallable;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class VirtualThreads_1 {
    public static void main(String[] args) {
        // Create a virtual thread executor
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 10; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Task " + taskId + " is running on " + Thread.currentThread());
                    try {
                        // Simulate some work
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Task " + taskId + " was interrupted");
                    }
                    System.out.println("Task " + taskId + " completed on " + Thread.currentThread());
                });
            }
        } // Executor is automatically closed here
    }

}

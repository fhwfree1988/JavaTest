package Sample.MultiThread.Atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt {
    //https://stackoverflow.com/questions/65656049/atomicinteger-is-not-working-properly-in-java
    public volatile AtomicBoolean isStopped = new AtomicBoolean(false);
    public AtomicInteger count =  new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicInt test = new AtomicInt();

        Thread writerThread = new Thread(() ->{
            while(!test.isStopped.get()) {
                test.count.incrementAndGet();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread readerThread = new Thread(() ->{
            while(!test.isStopped.get()) {
                System.out.println("Counter :"+test.count.get());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        writerThread.start();
        readerThread.start();

        Thread.sleep(4000);

        test.isStopped.getAndSet(true);

        writerThread.join();
        readerThread.join();
    }
}

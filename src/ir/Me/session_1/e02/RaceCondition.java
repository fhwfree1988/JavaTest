package ir.Me.session_1.e02;

import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicLong;

// This class exposes a publicly accessible counter
// to help demonstrate race condition problem
/*class Counter {
    public static *//*long*//* AtomicLong count = new AtomicLong(0);
}*/

// This class implements Runnable interface
// Its run method increments the counter three times
/*class UseCounter implements Runnable {
    final static Logger logger = Logger.getLogger(UseCounter.class);

    public void increment() {
// increments the counter and prints the value
// of the counter shared between threads

        //synchronized (this) {

        logger.info(Counter.count.incrementAndGet());
        //Counter.count = Counter.count + 1 ;


        //}
    }

    public void run() {
        increment();
        //logger.info(Counter.count.get() + " ");
        increment();
        //logger.info(Counter.count.get() + " ");
        increment();
        //logger.info(Counter.count.get() + " ");
    }
}*/

// This class creates three threads
/*public class RaceCondition {
    public static void main(String args[]) {
        UseCounter c = new UseCounter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
    }
}*/


//https://www.baeldung.com/cs/race-conditions
class Counter implements Runnable
{
    private int c = 0;
    public void increment()
    {
        try
        {
            Thread.sleep(10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        c++;
    }
    public void decrement()
    {
        c--;
    }
    public int getValue()
    {
        return c;
    }
    @Override
    public void run()
    {
       // synchronized(this)
        {
// incrementing
            this.increment();
            System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue());
//decrementing
            this.decrement();
            System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
        }
    }
}
public class RaceCondition
{
    public static void main(String args[])
    {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}

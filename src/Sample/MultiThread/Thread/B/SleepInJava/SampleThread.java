package Thread.B.SleepInJava;

import java.util.concurrent.TimeUnit;

public class SampleThread extends Thread {
    public SampleThread() {
        super();
        System.out.println("An instance of the " + SampleThread.class + " class was created!");
    }

    @Override
    public void run() {
        try {
            /* Sleep for some seconds.
             * Thread.sleep() method can be used to pause the execution of current thread for specified time in milliseconds.
              * The argument value for milliseconds can’t be negative, else it throws IllegalArgumentException. */
            TimeUnit.SECONDS.sleep(10);
        }
        catch(InterruptedException ex) {
            System.err.println("An InterruptedException was caught: " + ex.getMessage());
        }
    }
}

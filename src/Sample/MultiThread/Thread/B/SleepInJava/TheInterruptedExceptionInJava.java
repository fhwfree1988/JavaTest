package Sample.MultiThread.Thread.B.SleepInJava;

public class TheInterruptedExceptionInJava {

    public static void main(String[] args) throws InterruptedException {
        // Create a new thread.
        Thread thread = new SampleThread();

        //Start the thread's execution.
        thread.start();

        //Interrupt the thread.
        /*
        In Java, one thread cannot stop the other thread.
        A thread can only request the other thread to stop.
         The request is made in the form of an interruption.
         Calling the interrupt() method on an instance of a Thread sets the interrupt status state as true on the instance.
         */
        thread.interrupt();
        //thread.stop();
        /*
        Thread interruption is a gentle way to nudge a thread. It is used to give threads a chance to exit cleanly, as opposed to Thread.stop() that is more like shooting the thread with an assault rifle.
         */

        //Join the thread.
        thread.join();
    }

}

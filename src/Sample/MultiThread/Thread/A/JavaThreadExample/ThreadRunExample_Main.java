package Sample.MultiThread.Thread.A.JavaThreadExample;

public class ThreadRunExample_Main {
    public static void main(String[] args){
        Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
        Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");
        System.out.println("Starting Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Runnable Threads has been started");
        Thread t3 = new MyThread("t3");
        Thread t4 = new MyThread("t4");
        System.out.println("Starting MyThreads");
        t3.start();
        t4.start();
        /*
        Dead State:--->
        A thread is considered dead once its run() method completed execution.
         Although a thread’s run() method completed execution it is still a Thread object, but this Thread object is not a thread of execution.
         Once the thread completes its run() method and dead, it cannot be brought back to thread of execution or even to runnable state.
        Invoking start() method on a dead thread causes runtime exception.
         */
        System.out.println("MyThreads has been started");

    }
}

package Sample.MultiThread.Thread.Interrupt;

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread main started");
        final Task task = new Task();
        final Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(50);
        thread.interrupt(); // calling interrupt() method
        System.out.println("Main Thread finished");
    }
}
class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() + "] Message " + i);
            if(Thread.interrupted()) {
                System.out.println("This thread was interruped by someone calling this Thread.interrupt()");
                System.out.println("Cancelling task running in thread " + Thread.currentThread().getName());
                System.out.println("After Thread.interrupted() call, JVM reset the interrupted value to: " + Thread.interrupted());
                break;
            }
        }
    }
}
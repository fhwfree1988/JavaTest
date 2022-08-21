package Sample.MultiThread.Thread.Join;

class JoinSample extends Thread {
    public int processingCount = 0;

    public JoinSample(int processingCount) {
        this.processingCount = processingCount;
        System.out.println("Thread Created");
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " started");
        while (processingCount > 0) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + this.getName() + " interrupted");
            }
            processingCount--;
        }
        System.out.println("Thread " + this.getName() + " exiting");

    }

    public static void main(String[] args) {
        Thread t2 = new JoinSample(1);
        t2.start();
        System.out.println("Invoking join");
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Returned from join");
        System.out.println("t2.isAlive() : " +  t2.isAlive());
    }
}

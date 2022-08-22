package Sample.MultiThread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class SemaphoreSample {
//https://www.baeldung.com/java-concurrency
    //https://www.baeldung.com/java-util-concurrent
    public static void main(String[] args) {
        //----------LoginQueue
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
        IntStream.range(0, slots)
                .forEach(user -> executorService.execute(loginQueue::tryLogin));
        executorService.shutdown();

        //assertEquals(0, loginQueue.availableSlots());
        System.out.println("availableSlots : " + loginQueue.availableSlots());
        //assertFalse(loginQueue.tryLogin());
        System.out.println("tryLogin : " + loginQueue.tryLogin());
//---------------------------------------------------
        //-----------whenLogout
        ExecutorService executorService_Logout = Executors.newFixedThreadPool(slots);
        LoginQueueUsingSemaphore loginQueue_Logout = new LoginQueueUsingSemaphore(slots);
        IntStream.range(0, slots)
                .forEach(user -> executorService_Logout.execute(loginQueue_Logout::tryLogin));
        executorService_Logout.shutdown();
        //assertEquals(0, loginQueue_Logout.availableSlots());
        System.out.println("availableSlots_Logout : " + loginQueue_Logout.availableSlots());
        loginQueue_Logout.logout();

        //assertTrue(loginQueue_Logout.availableSlots() > 0);
        System.out.println("availableSlots_Logout_2 : " + loginQueue_Logout.availableSlots());
        //assertTrue(loginQueue_Logout.tryLogin());
        System.out.println("tryLogin : " + loginQueue_Logout.tryLogin());
    }
}

class LoginQueueUsingSemaphore {

    private Semaphore semaphore;

    public LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    void logout() {
        semaphore.release();
    }

    int availableSlots() {
        return semaphore.availablePermits();
    }

}
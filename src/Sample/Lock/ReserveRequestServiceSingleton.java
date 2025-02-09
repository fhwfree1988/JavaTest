package Sample.Lock;

import java.util.concurrent.locks.ReentrantLock;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ReserveRequestServiceSingleton {
    private static ReserveRequestServiceSingleton instance = null;
    private ReentrantLock reentrantLock = new ReentrantLock();
    public static ReserveRequestServiceSingleton getInstance(){
        if (instance == null) {
            instance = new ReserveRequestServiceSingleton();
        }
        return instance;
    }
    public Long saveRequest (Criteria reserveRequestCriteria){
        System.out.println("saveRequest Strat lock");
        //boolean isLockFree = reentrantLock.tryLock();
        reentrantLock.lock();
        try {
            System.out.println("saveRequest lock");
            //Thread.sleep(15000);
            return (Long) reserveRequestCriteria.uniqueResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("saveRequest Unlock");
            //reentrantLock.unlock();
        }
    }
}


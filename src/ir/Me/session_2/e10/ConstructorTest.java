package ir.Me.session_2.e10;

import org.apache.log4j.Logger;

public class ConstructorTest extends BaseConstructorClass {
    final static Logger logger = Logger.getLogger(ConstructorTest.class);
    
    public static void main(String[] args) {
        // default constructor
        BaseConstructorClass bc = new ConstructorTest();
        logger.info(bc);

        ConstructorTest c = new ConstructorTest();
//        ConstructorTest c = new ConstructorTest(6);
//        ConstructorTest c = new ConstructorTest(7, 4);

        logger.info(c.x);
        logger.warn(c.y);

        // Singleton test
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.x = 12;
        // same value
        logger.info(s2.x);
    }

    public ConstructorTest() {
//        logger.info("not compile!");
        this(10, 10);
    }

    public ConstructorTest(int x) {
        //        logger.info("not compile!");
        this(x, 10);
    }

    public ConstructorTest(int x, int y) {
        //        logger.info("not compile!");
        super(10);
        this.x = x;
        this.y = y;
    }


    public int x;
    public int y;
}


class BaseConstructorClass {
    public int a;

    public BaseConstructorClass(int a) {
        this.a = a;
    }
}

class Singleton {
    int x;

    private Singleton() {
    }

    private static final Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }
}
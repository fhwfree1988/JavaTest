package ir.Me.session_1.e05;

import org.apache.log4j.Logger;

public class ObjectTest {
    final static Logger logger = Logger.getLogger(ObjectTest.class);

    public static void main(String[] args) throws CloneNotSupportedException {
        TestObject object1 = new TestObject();

        logger.info("Object string value: " + object1);
        logger.info("Object toString value: " + object1.toString());
        logger.info("Object hashCode value: " + object1.hashCode());

        Object object2 = object1.clone();
        logger.info("object1 equals object2: " + object1.equals(object2));

        object1 = null;
//        System.gc();
    }
}

class TestObject implements Cloneable {
    final static Logger logger = Logger.getLogger(TestObject.class);

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public String toString() {
        return "TestObject";
    }

    @Override
    public void finalize() throws Throwable {
        logger.info("finalize called!");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

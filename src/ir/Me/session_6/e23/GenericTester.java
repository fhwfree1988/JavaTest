package ir.Me.session_6.e23;

import org.apache.log4j.Logger;

public class GenericTester {
    public static void main(String[] args) {
        MyGeneric<String> g = new MyGeneric<>();
        g.print("");
        g.test(18);
    }
}

class MyGeneric<T> {
    final static Logger logger = Logger.getLogger(MyGeneric.class);

    public void print(T t) {
        logger.info(t.getClass());
        if (t instanceof Integer) {
            Integer i = (Integer) t;
            i++;
            logger.info("int value: " + i);
        }
    }

    public <E extends Integer> void test(E e) {
        logger.info(e.getClass());
    }
}

class ParentGeneric<E> extends MyGeneric<E> {

}

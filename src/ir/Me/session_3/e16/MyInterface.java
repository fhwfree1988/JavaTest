package ir.Me.session_3.e16;

import org.apache.log4j.Logger;

public interface MyInterface {
    final static Logger logger = Logger.getLogger(MyInterface.class);
    
    static final int x = 12;

    static void showX() {
        logger.info(x);
    }

    default void showMessage() {
        logger.info("message from interface");
    }
}

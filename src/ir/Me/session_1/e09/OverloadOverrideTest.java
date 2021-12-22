package ir.Me.session_1.e09;

import org.apache.log4j.Logger;

public class OverloadOverrideTest extends BaseClass {
    final static Logger logger = Logger.getLogger(OverloadOverrideTest.class);
    
    public static void main(String[] args) {
        f1();
        f1("test!");

        BaseClass bc = new BaseClass();
        bc.getMessage();

        bc = new OverloadOverrideTest();
        bc.getMessage();
    }

    @Override
    public void getMessage() {
        logger.info("OverloadOverrideTest message");
    }

    public static void f1() {
        logger.info("f1");
    }

    public static void f1(String message) {
        logger.info("f1: " + message);
    }
}

class BaseClass {
    final static Logger logger = Logger.getLogger(BaseClass.class);

    protected void getMessage() {
        logger.info("BaseClass message");
    }
}

package ir.farzanehfar.session_2.e11;

// import static member

import org.apache.log4j.Logger;

import static ir.farzanehfar.session_2.e11.StaticClass.showMessage;
import static ir.farzanehfar.session_2.e11.StaticClass.ss;

public class StaticTest {
    final static Logger logger = Logger.getLogger(StaticTest.class);

    public static void main(String[] args) {
        StaticClass c1 = new StaticClass();
        StaticClass c2 = new StaticClass();

        c1.showMessage();
        c1.ss = "abc";

        ss = "new ss";
        logger.info(StaticClass.ss);
        showMessage();
    }
}

class StaticClass {
    final static Logger logger = Logger.getLogger(StaticClass.class);

    String s = "abc";

    {
        logger.info("normal block");
    }

    public static String ss = "static ss";

    static {
        logger.info("static block");
    }

    public static void showMessage() {
        logger.info("message");
    }
}
package ir.Me.session_1.e01;

import org.apache.log4j.Logger;

public class StringTest {
    final static Logger logger = Logger.getLogger(StringTest.class);
    
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        String s3 = new String("abc");
        String s4 = new String("abc");

        logger.info(s1 == s2);
        logger.info(s3 == s4);

        String log = String.format("head(%1$d) {left: %2$d , right : %3$d , startx : %4$d}",1,10,20,555);
        logger.info(log);
    }
}

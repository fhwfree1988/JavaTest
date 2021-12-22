package ir.Me.session_1.e01;

import org.apache.log4j.Logger;

public class StringTest {
    final static Logger logger = Logger.getLogger(StringTest.class);
    
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

//        String s1 = new String("abc");
//        String s2 = new String("abc");

        logger.info(s1 == s2);
    }
}

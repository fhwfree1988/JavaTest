package ir.Me.session_1.e08;

import org.apache.log4j.Logger;

import java.awt.*;

public class CallByValueTest {
    final static Logger logger = Logger.getLogger(CallByValueTest.class);

    public static void main(String[] args) {

        String s = "abc";
        changeString(s);
        logger.info("s: " + s);

        int x1 = 10, y1 = 20;
        swap1(x1, y1);
        logger.info("x1: " + x1);
        logger.info("y1: " + y1);

        Integer x2 = 10, y2 = 20;
        swap2(x2, y2);
        logger.info("x2: " + x2);
        logger.info("y2: " + y2);

        Point p = new Point(10, 20);
        swap3(p);
        logger.info("p.x2: " + p.x);
        logger.info("p.y2: " + p.y);


        java.util.Vector vc=new java.util.Vector();
        vc.add("111");
        vc.add("222");
        functioncall(vc);
        vc.add("333");
        System.out.println(vc);
    }

    public static void changeString(String s) {
        s = s + " change";
    }

    public static void swap1(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    public static void swap2(Integer x, Integer y) {
        Integer temp = x;
        x = y;
        y = temp;
    }

    public static void swap3(Point p) {
        Integer temp = p.x;
        p.x = p.y;
        p.y = temp;
    }

    public static void functioncall(java.util.Vector vc){
        vc.removeAllElements();
        //vc = null;
    }
}

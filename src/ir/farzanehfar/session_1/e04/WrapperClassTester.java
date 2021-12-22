package ir.farzanehfar.session_1.e04;

import org.apache.log4j.Logger;

public class WrapperClassTester {
    final static Logger logger = Logger.getLogger(WrapperClassTester.class);

    public static void main(String[] args) {
        speedTest();
        comparisionTest();
    }

    private static void speedTest() {
        int cnt = 100;// 1 -> 10000000

        //---------------------------
        long startTime = System.nanoTime();

        Long sumW = 0L;
        for (Integer i = 0; i < cnt; i++) {
            sumW += i;
        }
        logger.info(sumW);

        long endTime = System.nanoTime();
        long firstTime = endTime - startTime;

        //---------------------------
        startTime = System.nanoTime();

        long sum = 0L;
        for (int i = 0; i < cnt; i++) {
            sum += i;
        }
        logger.info(sum);

        endTime = System.nanoTime();
        long secondTime = endTime - startTime;

        //---------------------------
        double ratio = firstTime / (double) secondTime;
        logger.info("Ratio: " + Math.round(ratio * 100) / 100.0);
    }

    private static void comparisionTest() {
        int x = 6;
        Integer y = 6;
        Integer z = 6;
        logger.debug("primitive == wrapper");
        logger.info(x + ", " + y + " are " + compareResult(x == y));

        logger.debug("wrapper == wrapper");
        logger.info(y + ", " + z + " are " + compareResult(y == z));
        y = 128;
        z = 128;
        logger.info(y + ", " + z + " are " + compareResult(y == z));
        logger.debug("wrapper.equals(wrapper)");
        logger.info(y + ", " + z + " are " + compareResult(y.equals(z)));
    }

    private static String compareResult(boolean b) {
        if (b)
            return "equal";
        return "not equal";
    }
}

package ir.Me.session_1.e03;

import org.apache.log4j.Logger;

public class StringBuilderTest {
    final static Logger logger = Logger.getLogger(StringBuilderTest.class);

    public static void main(String[] args) {
        int cnt = 1; // 1 -> 100000

        //---------------------------
        long startTime = System.nanoTime();

        String s = "";
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 100; j++)
                s += "abcdefghijklmnopqrstuvwxyz";
        }
        long endTime = System.nanoTime();
        long stringTime = endTime - startTime;

        //---------------------------
        startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 100; j++)
                sb.append("abcdefghijklmnopqrstuvwxyz");
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        //---------------------------
        double ratio = stringTime / (double) stringBuilderTime;

        logger.info("Ratio: " + Math.round(ratio * 100) / 100.0);
    }
}

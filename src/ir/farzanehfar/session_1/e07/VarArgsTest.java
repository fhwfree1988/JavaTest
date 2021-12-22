package ir.farzanehfar.session_1.e07;

import org.apache.log4j.Logger;

public class VarArgsTest {
    final static Logger logger = Logger.getLogger(VarArgsTest.class);

    public static void main(String[] args) {
        logger.info(showVals(null));
        logger.info(showVals());
        logger.info(showVals("a"));
        logger.info(showVals("a", "b"));
        logger.info(showVals("a", "b", "c", "ss", "a",
                "b", "c", "ss", "a", "b", "c", "ss", "a", "b", "c", "ss"));
    }

    //    public static String showVals(String... args, int... args2) {
    public static String showVals(String... args) {
        if (args == null)
            return "null";

        StringBuilder sb = new StringBuilder();
        for (String s : args) {
            sb.append(s).append(" ");
        }

        return sb.toString();
    }
}

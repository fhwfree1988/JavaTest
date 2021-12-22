package ir.Me.session_6.e24;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTester {
    final static Logger logger = Logger.getLogger(ListTester.class);

    public static void main(String[] args) {
        sizeVsCapacity();
        iteratorTest();
    }

    private static void sizeVsCapacity() {
        List<Double> rs = new ArrayList<>();

        for (int cnt = 0; cnt < 100; cnt++) {
            long startTime = System.nanoTime();
            List ls = new ArrayList();
            for (int i = 0; i < 162504; i++) {
                ls.add(i);
            }
            long endTime = System.nanoTime();
            long withoutSize = endTime - startTime;

            startTime = System.nanoTime();
            ls = new ArrayList(162504);
            for (int i = 0; i < 162504; i++) {
                ls.add(i);
            }
            endTime = System.nanoTime();
            long withSize = endTime - startTime;
            double ratio = withoutSize / (double) withSize;
            rs.add(ratio);
        }

        logger.info("Avaerage: " +
                Math.round(rs.stream().mapToDouble(d -> d).average().getAsDouble() * 100) / 100.0);
    }

    private static void iteratorTest() {
        List<String> ls = Stream.of("first", "second", "third").collect(Collectors.toList());

        Iterator<String> iterator = ls.iterator();
        while (iterator.hasNext()) {
            logger.info(iterator.next());
        }
    }
}

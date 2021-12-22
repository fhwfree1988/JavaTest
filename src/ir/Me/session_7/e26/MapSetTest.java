package ir.Me.session_7.e26;

import org.apache.log4j.Logger;

import java.util.*;

public class MapSetTest {
    final static Logger logger = Logger.getLogger(MapSetTest.class);

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("b", "value 1");
        map.put("a", "value 2");
        map.put("c", "value 3");

        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        logger.info("HashMap:");
        while (iterator.hasNext()) {
            String k = iterator.next();
            logger.info("Key: " + k + ", value: " + map.get(k));
        }

        // -----------------------------------------
        map = new LinkedHashMap<>();
        map.put("b", "value 1");
        map.put("a", "value 2");
        map.put("c", "value 3");

        keys = map.keySet();
        iterator = keys.iterator();
        logger.info("LinkedHashMap:");
        while (iterator.hasNext()) {
            String k = iterator.next();
            logger.info("Key: " + k + ", value: " + map.get(k));
        }

        // -----------------------------------------
        map = new TreeMap<>();
        map.put("b", "value 1");
        map.put("a", "value 2");
        map.put("c", "value 3");

        keys = map.keySet();
        iterator = keys.iterator();
        logger.info("TreeMap:");
        while (iterator.hasNext()) {
            String k = iterator.next();
            logger.info("Key: " + k + ", value: " + map.get(k));
        }
    }
}


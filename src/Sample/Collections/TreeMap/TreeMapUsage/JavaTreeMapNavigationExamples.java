package Sample.Collections.TreeMap.TreeMapUsage;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
//https://www.journaldev.com/14512/java-treemap-treemap-in-java
/*
TreeMap entries are sorted in natural ordering of keys whereas HashMap doesn’t store entries in any order.
TreeMap doesn’t allow null key whereas we can have one null key in HashMap.
Since TreeMap stores entries in sorted way, it’s a bit slower that HashMap in storing and retrieving objects.
TreeMap uses Red-Black tree based NavigableMap implementation whereas HashMap uses hashing algorithm implementation.
TreeMap implements NavigableMap, so you get some extra features that are not present in HashMap. For example – submap, first key, last key, head map, tail map etc.
 */
public class JavaTreeMapNavigationExamples {
    public static void main(String[] args) {
        Map<Integer,String> myMap = new TreeMap<>();
        myMap.put(10, "10");
        myMap.put(1, "1");
        myMap.put(5, "5");
        System.out.println(myMap);

        myMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return (x > y ) ? -1 :((x==y)?0 : 1);
            }
        });
        myMap.put(10, "10");
        myMap.put(1, "1");
        myMap.put(5, "5");
        System.out.println(myMap);
        System.out.println(" -------------------------------- ");


        TreeMap<Integer,String> map = new TreeMap<>();
        for(int i=0;i<10;i++) {
            map.put(i, i+"");
        }
        System.out.println(map);

        //find id closest to 5, lower and higher
        Map.Entry<Integer,String> entry = map.lowerEntry(5);
        System.out.println("Closest Lower key than 5 is "+entry);
        entry = map.higherEntry(5);
        System.out.println("Closest Higher key than 5 is "+entry);

        System.out.println("Closest Lower key than 4 is "+map.lowerKey(4));

        entry = map.floorEntry(5);
        System.out.println("Closest floor entry than 5 is "+entry);

        entry = map.ceilingEntry(4);
        System.out.println("Closest ceiling key than 4 is "+entry);

        entry = map.firstEntry();
        System.out.println("First Entry is "+entry);

        entry = map.lastEntry();
        System.out.println("Last Entry is "+entry);

        Map<Integer, String> reversedMap = map.descendingMap();
        System.out.println("Reversed Map: "+reversedMap);

        //poll and remove first, last entries
        entry = map.pollFirstEntry();
        System.out.println("First Entry is "+entry);
        entry = map.pollLastEntry();
        System.out.println("Last Entry is "+entry);
        System.out.println("Updated Map: "+map);

        //submap example
        Map<Integer, String> subMap = map.subMap(2, true, 6, true);
        System.out.println("Submap: "+subMap);

        subMap = map.headMap(5, true);
        System.out.println("HeadMap: "+subMap);

        subMap = map.tailMap(5, true);
        System.out.println("TailMap: "+subMap);
    }
}

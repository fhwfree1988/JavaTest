package Sample.Collections.Map.HashMap;


import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class HashMapEntrySetExample {

    //https://www.journaldev.com/11560/java-hashmap
    /*
    This entrySet is backed by HashMap, so any changes in map reflects in entry set and vice versa
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", null);
        map.put(null, "100");

        Set<Entry<String,String>> entrySet = map.entrySet();
        Iterator<Entry<String, String>> iterator = entrySet.iterator();
        Entry<String, String> next = null;

        System.out.println("map before processing = "+map);
        System.out.println("entrySet before processing = "+entrySet);
        while(iterator.hasNext()){
            next = iterator.next();
            System.out.println("Processing on: "+next.getValue());
            if(next.getKey() == null) iterator.remove();
        }

        System.out.println("map after processing = "+map);
        System.out.println("entrySet after processing = "+entrySet);

        Entry<String, String> simpleEntry = new AbstractMap.SimpleEntry<String, String>("1","1");
        entrySet.remove(simpleEntry);
        System.out.println("map after removing Entry = "+map);
        System.out.println("entrySet after removing Entry = "+entrySet);

        //---------------------------------
        List<String> fruits = Arrays.asList("apple","mango");
        System.out.println(fruits.stream().map(fruit -> fruit.split("")).flatMap(Arrays::stream).collect(Collectors.toSet()));

    }

}

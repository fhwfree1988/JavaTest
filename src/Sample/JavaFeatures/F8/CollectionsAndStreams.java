package Sample.JavaFeatures.F8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionsAndStreams {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("franz", "ferdinand", "fiel", "vom", "pferd","Mom Mom Mom Mom");

        //Now pre-Java 8 you basically had to write for-loops to do something with that list.
        //With the Streams API, you can do the following:

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 != null && o2 != null)
                {
                    if(o1 instanceof String && o2 instanceof String){
                        if(((String) o2).length() > ((String) o1).length())
                            return 1;
                        else if (((String) o2).length() < ((String) o1).length())
                            return -1;
                    }
                }
                return 0;
            }
        };

        list.stream()
                .filter(name -> name.startsWith("f"))
                .map(String::toUpperCase)
                .sorted(comparator)
                .forEach(System.out::println);
    }
}

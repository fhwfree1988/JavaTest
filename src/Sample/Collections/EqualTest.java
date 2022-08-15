package Sample.Collections;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class EqualTest {
    public static void main(String[] args) {
        String[] array = new String[]{"A","B","C"};
        List<String> list1 = Arrays.asList(array);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        List<String> list3 = new ArrayList<>(Arrays.asList("A",new String("B"),"C"));

        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));

        //----------------- Capitalizing by Function
        List<String> songTitles = Arrays.asList("humble","element","dna");
        Function<String,String> capitalize = str -> str.toUpperCase();
        songTitles.stream().map(capitalize).forEach(System.out::println);
    }
}

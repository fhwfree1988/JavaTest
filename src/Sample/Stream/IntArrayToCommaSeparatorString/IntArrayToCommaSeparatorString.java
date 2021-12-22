package Sample.Stream.IntArrayToCommaSeparatorString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntArrayToCommaSeparatorString {
    public static void main(String[] args) {
        int[] intArray={1,2,3,4,5,6,7,8};
        //1)First Way
        String strArray = IntStream.of(intArray).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(strArray);


        //2)Second Way
        Iterable<String> iteratable = Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.toList());
        String joined = String.join(",", iteratable);
        System.out.println(joined);

        //Iterator<Integer> iterator = Arrays.stream(intArray).iterator();
        //Iterator<Integer> iterator = IntStream.of(intArray).boxed().iterator();
        //Iterator<Integer> iterator =  IntStream.of(intArray).iterator().;
    }
}

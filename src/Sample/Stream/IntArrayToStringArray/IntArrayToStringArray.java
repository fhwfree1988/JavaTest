package Sample.Stream.IntArrayToStringArray;

import java.util.Arrays;

public class IntArrayToStringArray {
    public static void main(String[] args) {
        int[] intArray={1,2,3,4,5,6,7,8};
        String strArray[] = Arrays.stream(intArray)
                .mapToObj(String::valueOf).toArray(String[]::new);

        System.out.println(Arrays.toString(strArray));
    }
}

package Sample.IteratorAndIterable.IteratorVSIterable;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            System.out.println(string);
        }
    }
}

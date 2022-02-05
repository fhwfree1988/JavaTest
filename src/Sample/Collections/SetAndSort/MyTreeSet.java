package Sample.Collections.SetAndSort;

import java.util.Set;
import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {
        Set<String> mySet =  new TreeSet();
        mySet.add("Ali");
        mySet.add("Javad");
        mySet.add("Naser");
        mySet.add("Mohammad");
        mySet.add("Reza");
        mySet.add("RE");
        mySet.add("Ahmad");

        System.out.println(mySet.toString());
    }
}

package Sample.Collections.SetAndSort;
import java.util.Set;
import java.util.SortedSet;
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

        //-------------------------Java TreeSet Comparable-------------
        SortedSet<myPerson> sortedSet = new TreeSet<>();
        sortedSet.add(new myPerson(1, "Mark"));
        sortedSet.add(new myPerson(2, "Vispi"));
        sortedSet.add(new myPerson(3, "Harmony"));
        sortedSet.forEach(System.out::println);


        //--------------------------Java TreeSet Comparator-------------------------
        // we can also provide instance of Comparator implementation instead of lambda
        SortedSet<myPerson> customOrderedSet = new TreeSet<>((p1, p2) -> p1.id - p2.id);
        customOrderedSet.addAll(sortedSet);
        customOrderedSet.forEach(System.out::println);
    }


}



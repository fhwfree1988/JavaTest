package Sample.Collections.ListIterator;

import java.util.*;
import java.util.stream.Stream;

public class  MyListTest {
    public static void main(String[] args) {
        //List<String> myList = Arrays.asList("Ali","Javad","Naser","Mohammad","Reza","RE","Ahmad");
        List<String> myList = new ArrayList();
        myList.add("Ali");
        myList.add("Javad");
        myList.add("Naser");
        myList.add("Mohammad");
        myList.add("Reza");
        myList.add("RE");
        myList.add("Ahmad");

        Set<String> mySet = new HashSet(myList);
        Iterator<String> myIterator = myList.iterator();

        while(myIterator.hasNext()){
            String val = myIterator.next();
            if(val.equals("RE")) {
                myIterator.remove();
                //myList.remove(val);
            }
        }

        System.out.println(myList.toString());
        System.out.println(mySet.toString());



        //-----------------------------------------------------------
        List<Integer> ints = new ArrayList<>();
        for(int i=0; i<10; i++) ints.add(i);

        Iterator<Integer> it = ints.iterator();

        //simple iteration
        while(it.hasNext()){
            int x = (int) it.next();
            System.out.print(x + ", ");
        }
        System.out.println("\n"+ints);

        //modification of list through iterator
        it = ints.iterator();
        while(it.hasNext()){
            int x = (int) it.next();
            if(x%2 ==0) it.remove();
        }
        System.out.println(ints);

        //changing list structure while iterating
        it = ints.iterator();
        while(it.hasNext()){
            int x = (int) it.next(); //ConcurrentModificationException here
            if(x==5) ints.add(20);
        }
    }
}

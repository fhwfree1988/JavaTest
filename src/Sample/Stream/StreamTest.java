package Sample.Stream;

import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        class MyStreamPerson{
            int ID = 0;
            String Name ="";
            public MyStreamPerson(int ID,String Name){
                this.Name = Name;
                this.ID = ID;
            }

        }

        class MyStreamPerson2{
            int ID = 0;
            String Name ="";
            int age = 0;
            public MyStreamPerson2(int ID,String Name,int age){
                this.Name = Name;
                this.ID = ID;
                this.age = age;
            }

        }

        List<MyStreamPerson> persons = new ArrayList<>();
        MyStreamPerson p1 = new MyStreamPerson(1,"Ali");
        MyStreamPerson p2 = new MyStreamPerson(2,"Reza");
        MyStreamPerson p3 = new MyStreamPerson(3,"Mohsen");
        MyStreamPerson p4 = new MyStreamPerson(4,"AliReza");
        MyStreamPerson p5 = new MyStreamPerson(5,"Naser");
        persons.add(p1);persons.add(p2);persons.add(p3);persons.add(p4);persons.add(p5);

        persons.forEach(X-> System.out.println(X.ID + ") " + X.Name));
        System.out.println("-----------------------------");


        List<MyStreamPerson2> persons2 = persons.stream().filter(X -> X.Name.toLowerCase().contains("a"))
                                                         .map(X -> new MyStreamPerson2(X.ID,X.Name, X.ID + 20))
                                                         .collect(Collectors.toList());


        persons2.forEach(X-> System.out.println(X.ID + ") " + X.Name + " --> age: " +X.age));

    }
}

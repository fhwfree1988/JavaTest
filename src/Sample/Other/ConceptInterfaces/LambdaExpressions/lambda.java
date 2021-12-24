package Sample.Other.ConceptInterfaces.LambdaExpressions;

import Sample.Other.Models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class lambda {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry", 3500);
        staff[1] = new Employee("Carl", 1500);
        staff[2] = new Employee("Tony", 2500);

        /*class NameComparator implements Comparator<Employee> {
            @Override
            public int compare(Employee first, Employee second) {
                Logger.getGlobal().info("Comparing " + first + " and " + second);
                return first.getName().compareTo(second.getName());
            }
        }*/

        //Arrays.sort(staff, new NameComparator());
        Arrays.sort(staff, (first, second) -> first.getName().compareTo(second.getName()));
        Arrays.stream(staff).forEach(System.out::println);

        //Timer t1 = new Timer(1000, event -> System.out.println(event));
        //Timer t2 = new Timer(1000, System.out::println);
        //ArrayList<Employee> listEmps = Stream.toArray(staff[]::new);
        //Stream<Employee> Emps = Arrays.stream(staff).map(Employee::new);

    }
}

package Sample.Other.ConceptInterfaces;



import Sample.Other.ConceptInterfaces.DefualtStatic.EvaluateEmployee;
import Sample.Other.Models.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

public class Comparable {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry", 3500);
        staff[1] = new Employee("Carl", 1500);
        staff[2] = new Employee("Tony", 2500);

        Arrays.sort(staff);
        //System.out.println(Arrays.toString(staff));
        Arrays.stream(staff).forEach(System.out::println);

        EvaluateEmployee eval = new EvaluateEmployee(staff[0]);
        System.out.println(eval.ConsiderInsurance());

        class NameComparator implements Comparator<Employee> {
            @Override
            public int compare(Employee first, Employee second) {
                Logger.getGlobal().info("Comparing " + first + " and " + second);
                return first.getName().compareTo(second.getName());
            }
        }

        Arrays.sort(staff, new NameComparator());
        Arrays.stream(staff).forEach(System.out::println);

    }
}

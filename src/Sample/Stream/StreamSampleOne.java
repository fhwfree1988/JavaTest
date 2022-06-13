package Sample.Stream;

import Sample.Other.Models.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
class employeeRepository{
    public static Employee findById(int id){
        return Arrays.stream(StreamSampleOne.arrayOfEmps).filter(X -> X.getID() == id ).findFirst().orElse(null);
    }
}
public class StreamSampleOne {
//https://stackify.com/streams-guide-java-8/
    public static Employee[] arrayOfEmps ={
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2,"Bill Gates", 200000.0),
            new Employee(3,"Mark Zuckerberg", 300000.0)
    };

    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
    public static void main(String[] args) {
        Stream.of(arrayOfEmps);

        empList.stream();

        whenIncrementSalaryForEachEmployee_thenApplyNewSalary();
        whenMapIdToEmployees_thenGetEmployeeStream();
    }

    @Test
    public static void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
        empList.stream().forEach(e -> e.salaryIncrement(10.0));

        /*assertThat(empList, contains(
                hasProperty("salary", equalTo(110000.0)),
                hasProperty("salary", equalTo(220000.0)),
                hasProperty("salary", equalTo(330000.0))
        ));*/
    }

    @Test
    public static void whenMapIdToEmployees_thenGetEmployeeStream() {
        Integer[] empIds = { 1, 2, 3 };

        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .collect(Collectors.toList());

        assertEquals(employees.size(), empIds.length);
    }

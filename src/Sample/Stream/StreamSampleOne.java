package Sample.Stream;

import Sample.Other.Models.Employee;

import java.util.stream.Stream;

public class StreamSampleOne {
//https://stackify.com/streams-guide-java-8/
    private static Employee[] arrayOfEmps ={
            new Employee( "Jeff Bezos", 100000.0),
            new Employee("Bill Gates", 200000.0),
            new Employee( "Mark Zuckerberg", 300000.0)
    };

    public static void main(String[] args) {
        Stream.of(arrayOfEmps);

        private
    }
}

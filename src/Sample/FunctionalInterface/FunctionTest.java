package Sample.FunctionalInterface;

// Java Program to Illustrate Functional Interface
// Via apply() method

// Importing interface
import java.util.function.Function;

// Main class
public class FunctionTest {

    // Main driver method
    public static void main(String args[])
    {
        // Function which takes in a number
        // and returns half of it
        Function<Integer, Double> half = a -> a / 2.0;

        // Applying the function to get the result
        System.out.println(half.apply(10));

        Function<Integer, String> Definition = (a) -> {
            switch (a){
                case 1:
                    return "A";

                case 2:
                    return "B";

                default:
                    return "C";

            }
        };

        // Applying the function to get the result
        System.out.println(Definition.apply(1));
    }
}
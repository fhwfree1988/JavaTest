package Sample.FunctionalInterface;

// Java Program to Illustrate Functional Interface
// Via apply() method

// Importing interface
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

// Main class
public class FunctionTest {

    //https://www.geeksforgeeks.org/function-interface-in-java-with-examples/

    public static void main(String args[])
    {
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


        //------------------------
        System.out.println("---------DATE");
        List<String> dates = new ArrayList<String>();
        dates.add("1900/01/01");
        dates.add("1988/05/01");
        dates.add("2000/09/06");

        UnaryOperator<String> replaceSlashes = date -> date.replace("/","-");
        dates.replaceAll(replaceSlashes);
        dates.stream().forEach(System.out::println);

        //-----------------------------------
        //https://stackoverflow.com/questions/43849066/java-8-functions-compose-and-andthen
        final double startNumber = 3.5;

        final Function<Double, Double> cubeRoot = x -> {
            System.out.println("Calculating cube root");
            return Math.pow(x, 1.0/3);
        };

        final Function<Double, Double> square = x -> {
            System.out.println("Calculating square");
            return Math.pow(x, 2);
        };

        final Function<Double, Long> round = x -> {
            System.out.println("Rounding");
            return Math.round(x);
        };

        Long result = cubeRoot.andThen(square).andThen(round).apply(startNumber);
        System.out.println("Result: " + result);

        result = round.compose(square).compose(cubeRoot).apply(startNumber);
        System.out.println("Result: " + result);
    }
}
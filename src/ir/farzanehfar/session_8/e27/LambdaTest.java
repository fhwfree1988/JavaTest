package ir.farzanehfar.session_8.e27;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaTest {
    final static Logger logger = Logger.getLogger(LambdaTest.class);

    public static void main(String[] args) throws IOException {
        // stream types
        Stream directStream = Stream.of("a", "b", "c");

        List<String> stringList = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
        }};
        Stream listStream = stringList.stream();

        String[] stringArray = new String[]{"a", "b", "c", "a", "b", "c"};
        Stream arrayStream = Arrays.stream(stringArray);

        IntStream primitiveStream = IntStream.range(1, 6);

        Stream fileStream = Files.lines(Paths.get("D:\\a.txt"));

        IntStream charStream = "some text".chars();

        // Intermediate operations
        directStream = directStream.filter(s -> s.toString().compareTo("c") < 0);

        listStream = listStream.map(s -> Integer.parseInt(s.toString()));

        arrayStream = arrayStream.distinct();

        charStream = charStream.sorted();

        // Terminal operations
        directStream.forEach(s -> logger.info(s));

        logger.info("count is: " + charStream.count());

        logger.info("sum is: " + primitiveStream.sum());

        // filtering
        Stream<String> testStream = Stream.of("hasan", "ali", "reza");
        if (testStream.anyMatch(s -> s.equals("hasan"))) {
            logger.info("hasan exists!");
        }

        testStream = Stream.of("hasan", "ali", "reza");
        if (testStream.noneMatch(s -> s.equals("hasan"))) {
            logger.info("hasan not exists!");
        }

        testStream = Stream.of("ahmad", "ali", "behnam");
        if (testStream.allMatch(s -> s.startsWith("a"))) {
            logger.info("all start with a!");
        }

        testStream = Stream.of("ahmad", "ali", "behnam", "ali reze");
        Optional<String> opt = testStream.filter(s -> s.startsWith("ali")).findFirst();
        if (opt.isPresent()) {
            logger.info("ali found: " + opt.get());
        }

        LongSummaryStatistics lss = Stream.of(18, 12, 5, 16).mapToLong(i -> i).summaryStatistics();
        logger.info("count is:" + lss.getCount());
        logger.info("sum is:" + lss.getSum());
        logger.info("average is:" + lss.getAverage());
        logger.info("min is:" + lss.getMin());
        logger.info("max is:" + lss.getMax());

        logger.info("Sorted list: ");
        Stream.of(18, 12, 5, 16).sorted().forEach(i -> logger.info(i));

        // save to collections
        List<Integer> collectedInts = Stream.of(18, 25, 36, -45).collect(Collectors.toList());

        String[] sArray = "a sample text".split(" ");
        Set words = Arrays.stream(sArray).collect(Collectors.toSet());

        Map<String, Integer> nameLength = Stream.of("ali", "reza", "hosein")
                .collect(Collectors.toMap(name -> name, name -> name.length()));

        Map<Integer, List<String>> wordGroups = Stream.of("ali", "hasan", "hamed", "reza", "hosein")
                .collect(Collectors.groupingBy(String::length));

        Map<Boolean, List<String>> wordPartitions = Stream.of("ali", "hasan", "hamed", "reza", "hosein")
                .collect(Collectors.partitioningBy(s -> s.toString().length() > 3));


        if (true) return;
        //---------------------------------------------------
        System.out.println("Squared numbers: ");
        IntStream.range(1, 5).peek(i -> System.out.printf("%d ", i))
                .map(i -> i * i).peek(i -> System.out.printf("%d ", i)).count();

        System.out.println("Even numbers: ");

        IntStream.rangeClosed(0, 10).filter(i -> (i % 2) == 0).forEach(i -> System.out.printf("%d ", i));

        List<String> strings = Stream.of("abc", "bc", "efg", "abcd", "jkl", " ", "").collect(Collectors.toList());

        logger.info("All strings count: " + strings.stream().count());
        Predicate<String> nullCheck = s -> s == null;
        Predicate<String> emptyCheck = s -> s.trim().equals("");
        logger.info("Not null or empty strings count: " + strings.stream()
                .filter(nullCheck.or(emptyCheck).negate()).count());

        strings.removeIf(nullCheck.or(emptyCheck));
        logger.info("All strings count after remove: " + strings.stream().count());

        logger.info("Consumer test: ");
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        strings.stream().forEach(printUpperCase);


        Function<String, String> addA = str -> str + "A";
        Function<String, String> addB = str -> str + "B";

        logger.info("andThen test: ");
        strings.stream().map(addA.andThen(addB)).forEach(System.out::println);
        logger.info("compose test: ");
        strings.stream().map(addA.compose(addB)).forEach(System.out::println);

        logger.info("compose test: ");
        Random random = new Random();
        Supplier<Integer> randomInt = () -> random.nextInt(100);
        Stream.generate(randomInt).limit(5).forEach(System.out::println);

        List<Integer> ints = Arrays.asList(-12, -18, -63, 0);

        logger.info("anyMatch test: ");
        if (ints.stream().anyMatch(i -> i > 0))
            logger.info("Positive found!");
        else
            logger.info("Positive not found!");

        logger.info("allMatch test: ");
        if (ints.stream().allMatch(i -> i < 0))
            logger.info("All negative found!");
        else
            logger.info("All negative not found!");

        logger.info("noneMatch test: ");
        if (ints.stream().noneMatch(i -> i > 0))
            logger.info("All negative and zero found!");
        else
            logger.info("All negative and zero not found!");

        logger.info("findFirst: " + ints.stream().findFirst().get());
        logger.info("findAny: " + ints.stream().findAny().get());

        IntSummaryStatistics statistics = ints.stream().mapToInt(i -> i).summaryStatistics();
        logger.info("IntSummaryStatistics, min: " + statistics.getMin() + ", max: " + statistics.getMax() +
                ", sum: " + statistics.getSum() + ", avr: " + statistics.getAverage());

        // test sorted
        class Person {
            String name;
            int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }
        Comparator<Person> nameCompare = (p1, p2) -> Objects.compare(p1.name, p2.name, String::compareTo);
        Comparator<Person> ageCompare = (p1, p2) -> Objects.compare(p1.age, p2.age, Integer::compareTo);

        List<Person> people = Arrays.asList(
                new Person("ali", 18),
                new Person("reza", 19),
                new Person("hasan", 24));
        logger.info("Sort result:");
        people.stream().sorted(nameCompare.thenComparing(ageCompare)).forEach(System.out::println);


        // flatMap
        List<List<Integer>> intsOfInts = Arrays.asList(Arrays.asList(1, 3, 5), Arrays.asList(2, 4));
        intsOfInts.stream().flatMap(ins -> ins.stream()).sorted().map(i -> i * i).forEach(System.out::println);
    }
}

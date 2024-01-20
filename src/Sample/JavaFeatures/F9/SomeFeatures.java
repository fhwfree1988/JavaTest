package Sample.JavaFeatures.F9;

import Sample.MultiThread.Callable.MyCallable;

import java.util.*;
import java.util.concurrent.ThreadFactory;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class SomeFeatures {
    public static void main(String[] args) {
        //Collections
        //Collections got a couple of new helper methods, to easily construct Lists, Sets and Maps.
        List<String> list = List.of("one", "two", "three");
        Set<String> set = Set.of("one", "two", "three");
        Map<String, String> map = Map.of("foo", "one", "bar", "two");

        //----------------------------------------------------------

        // Streams
        // Streams got a couple of additions, in the form of takeWhile,dropWhile,iterate methods.
        Stream<String> stream = Stream.iterate("", s -> s + "s")
        .takeWhile(s -> s.length() < 10);

        //-----------------------------------------------------------

        //Optionals
        //Optionals got the sorely missed ifPresentOrElse method.
        Runnable printThread = () -> System.out.println("Hello Virtual Thread! Value is Null");
        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        Thread virtualThread = virtualThreadFactory.newThread(printThread);
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("Hello Virtual Thread! Value is not Null");
            }
        };
        //Optional<MyCallable> call = Optional.of(new MyCallable());
        Optional<MyCallable> call = Optional.ofNullable(null);
        call.ifPresentOrElse(consumer, /*virtualThread*/printThread);
    }
}

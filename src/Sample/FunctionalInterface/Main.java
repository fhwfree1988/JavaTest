package Sample.FunctionalInterface;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
                new Car("Benz", "Black", 800000),
                new Car("BMW", "Black", 700000),
                new Car("Pride", "red", 200000),
                new Car("Cherry", "Black", 100000),
                new Car("Citroen", "red", 400000),
                new Car("206", "Black", 300000),
                new Car("405", "red", 100000),
                new Car("Prado", "Black", 500000),
                new Car("Fiat", "red", 600000),
                new Car("Ford", "Black", 1000000),
                new Car("Jilly", "Black", 1200000)

        );

        //************ Predicate ************
        Predicate<Car> carPredicate1
                = (car) -> {
            return car.getColor().equals("Black");
        };

        Predicate<Car> carPredicate2
                = (car) -> {
            return !car.getName().equals("B");
        };

        //************ Comparator ************
        Comparator<Car> carComparator
                = (car1, car2) -> {
            return car1.getPrice() - car2.getPrice();
        };

        //************ Function ************
        Function<Car, Integer> carFunction
                = (car) -> {
            return car.getPrice();
        };

        //************ Consumer ************
        Consumer<Integer> carConsumer
                = System.out::println;

        //************ Stream ************
        filter(cars, carPredicate1)
                .stream()
                .filter(carPredicate2)
                .sorted(carComparator)
                .map(carFunction)
                .forEach(carConsumer);
    }


    private static <T> List<T> filter(List<T> list, Predicate<T> condition) {

        List<T> newList = new ArrayList<>();

        if (true) {
            for (T t : list) {
                if (condition.test(t)) {
                    newList.add(t);
                }
            }
        }
        return newList;
    }
}

class Car {
    private String name;
    private String color;
    private int price;

    public Car() {
    }

    public Car(String name, String color, int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
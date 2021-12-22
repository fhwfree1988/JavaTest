package ir.farzanehfar.session_6.e25;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortTester {
    final static Logger logger = Logger.getLogger(SortTester.class);

    public static void main(String[] args) {
        Engineer[] es = new Engineer[3];
        es[0] = new Engineer(22, "hasan", 2000000, 1);
        es[1] = new Engineer(32, "reza", 3500000, 7);
        es[2] = new Engineer(27, "ali", 3700000, 3);
        // sort by Comparable
        Arrays.sort(es);

        logger.info("Engineers sort by Comparable:");
        for (Engineer er : es) {
            logger.info(er);
        }

        PersonComparator personComparator = new PersonComparator();
        // sort by Comparator
        Arrays.sort(es, personComparator);
        logger.info("Engineers sort by Comparator:");
        for (Engineer er : es) {
            logger.info(er);
        }

        Doctor[] ds = new Doctor[3];
        ds[0] = new Doctor(28, "Dr. javad", 5000000, 1);
        ds[1] = new Doctor(31, "Dr. hosein", 8500000, 5);
        ds[2] = new Doctor(35, "Dr. hamed", 6800000, 3);
        // sort by Comparable
        Arrays.sort(es);

        List<Doctor> doctorList = Arrays.asList(ds);
        logger.info("Doctors sort by Comparable:");
        for (Doctor dr : ds) {
            logger.info(dr);
        }

        // sort by Comparator
        Arrays.sort(ds, personComparator);
        logger.info("Doctors sort by Comparator:");
        for (Doctor dr : ds) {
            logger.info(dr);
        }
    }
}

abstract class Person {
    public int age;
    public String name;
    public int salary;

    public Person(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }
}

class Engineer extends Person implements Comparable<Engineer> {
    @Override
    public String toString() {
        return "Engineer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", exp=" + exp +
                '}';
    }

    public int exp;

    public Engineer(int age, String name, int salary, int exp) {
        super(age, name, salary);
        this.exp = exp;
    }

    @Override
    public int compareTo(Engineer o) {
        return Integer.compare(exp, o.exp);
    }
}

class Doctor extends Person implements Comparable<Doctor> {
    @Override
    public String toString() {
        return "Doctor{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", grade=" + grade +
                '}';
    }

    public int grade;

    public Doctor(int age, String name, int salary, int grade) {
        super(age, name, salary);
        this.grade = grade;
    }

    @Override
    public int compareTo(Doctor o) {
        return Integer.compare(grade, o.grade);
    }
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.salary, o2.salary);
    }
}
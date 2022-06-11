package Sample.Other.Models;

public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary,o.salary);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[Name:" + name + ",Salary:" + salary +"]";
    }

    public void salaryIncrement(double val) {
        this.salary+=val;
    }
}

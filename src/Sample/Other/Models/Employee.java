package Sample.Other.Models;

public class Employee implements Comparable<Employee>{
    private int ID;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.ID = 0;
        this.name = name;
        this.salary = salary;
    }
    public Employee(int id ,String name, double salary) {
        this.ID = id;
        this.name = name;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

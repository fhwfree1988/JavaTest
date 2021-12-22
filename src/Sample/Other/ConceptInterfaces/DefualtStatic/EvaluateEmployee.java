package Sample.Other.ConceptInterfaces.DefualtStatic;

import org.Models.Employee;

public class EvaluateEmployee implements Evaluate {
    double salary;

    public EvaluateEmployee(Employee e) {
        this.salary = e.getSalary();
    }

    @Override
    public double getMount() {
        return salary;
    }

    @Override
    public double ConsiderInsurance() {
        return salary - 100;
    }
}

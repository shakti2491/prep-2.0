package designpatterns.behavioral.visitor;

import java.util.Collection;

public abstract class AbstractEmployee implements Employee{

    private int performanceRating;

    private String name;

    private static  int employeeIdCounter = 101;

    private int employeeId;

    public AbstractEmployee(String name){
        this.name = name;
        employeeId = employeeIdCounter++;
    }

    @Override
    public int getPerformanceRating() {
        return this.performanceRating;
    }

    @Override
    public void setPerformanceRating(int rating) {

    }

    @Override
    public int getEmployeeId() {
        return 0;
    }

    @Override
    public Collection<Employee> getDirectReports() {
        return null;
    }
}

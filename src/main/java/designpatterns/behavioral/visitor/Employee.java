package designpatterns.behavioral.visitor;

import java.util.Collection;

public interface Employee {

    int getPerformanceRating();
    void setPerformanceRating(int rating);
    int getEmployeeId();
    Collection<Employee> getDirectReports();

    void accept(Visitor visitor);
}

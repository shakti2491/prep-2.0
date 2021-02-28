package designpatterns.behavioral.memento;

import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;

@ToString
@Data
public class WorkFlow {
    private LinkedList<String> steps;
    private String name;

    public WorkFlow(String  name){
        this.name = name;
        this.steps = new LinkedList<>();
    }
    public WorkFlow(String name, String... steps){
        this.name = name;
        this.steps = new LinkedList<>();
        if(steps!=null && steps.length>0){
            Arrays.stream(steps).forEach(step -> this.steps.add(step));
        }
    }

    public void addStep(String step){
        this.steps.add(step);
    }

    public void removeStep(String step) {
        this.steps.remove(step);
    }
}

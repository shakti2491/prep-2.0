package designpatterns.behavioral.memento;

public class AddStepCommand extends AbstractWorkFlowCommand{
    private String step;

    public AddStepCommand(WorkFlowDesigner receiver, String step){
        super(receiver);
        this.step = step;
    }

    @Override
    public void execute() {
        // get the memento of the workflow state
        this.memento = receiver.getMemento();
        receiver.addStep(step);
    }
}

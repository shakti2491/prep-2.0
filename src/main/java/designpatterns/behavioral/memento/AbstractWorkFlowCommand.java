package designpatterns.behavioral.memento;

public  abstract class AbstractWorkFlowCommand implements WorkFlowCommand{

    protected WorkFlowDesigner.Memento memento;
    protected WorkFlowDesigner receiver;

    public AbstractWorkFlowCommand(WorkFlowDesigner designer){
        this.receiver = designer;
    }
    @Override
    public void undo() {
        this.receiver.setMemento(memento);
    }
}

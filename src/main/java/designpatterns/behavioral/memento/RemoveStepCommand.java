package designpatterns.behavioral.memento;

public class RemoveStepCommand extends AbstractWorkFlowCommand{

        private String step;

        public RemoveStepCommand(WorkFlowDesigner receiver, String step){
            super(receiver);
            this.step = step;
        }

        @Override
        public void execute() {
            // get the memento of the workflow state
            this.memento = receiver.getMemento();
            receiver.removeStep(step);
        }


}

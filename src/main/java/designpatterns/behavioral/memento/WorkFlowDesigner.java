package designpatterns.behavioral.memento;

public class WorkFlowDesigner {
    private WorkFlow workFlow;

    public void createWorkFlow(String name){
        workFlow = new WorkFlow(name);
    }
    public Memento getMemento(){
        if(workFlow==null)
            return new Memento();
        return new Memento(workFlow.getSteps().toArray(String[]::new), workFlow.getName());
    }

    public void setMemento(Memento memento){
        if(memento.isEmpty()){
            this.workFlow = null;
        }

        else{
            this.workFlow = new WorkFlow(memento.getName(), memento.getSteps());
        }
    }

    public void addStep(String step){
        workFlow.addStep(step);
    }

    public void removeStep(String step) {
        workFlow.removeStep(step);
    }

    public class Memento{
        private String[] steps;

        private String name;
        private Memento(){

        }
        private Memento(String[] steps, String name){
            this.steps = steps;
            this.name = name;
        }

        private String[] getSteps(){
            return steps;
        }

        private String getName(){
            return this.name;
        }

        private boolean isEmpty(){
            return this.getSteps()==null && this.getName()==null;
        }
    }
}

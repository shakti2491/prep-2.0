package designpatterns.behavioral.mediator;

public class TextBox implements UIControl{

    private UIMediator mediator;
    private boolean myUpdate;
    private boolean mediatedUpdate;
    public TextBox(UIMediator mediator){
        this.mediator = mediator;
        this.mediator.register(this);


    }

    @Override
    public void controlChanged(UIControl control) {
    }

    @Override
    public String getControlName() {
        return null;
    }

    @Override
    public String getControlValue() {
        return null;
    }
}

package designpatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class UIMediator {

    List<UIControl> colleagues = new ArrayList<>();
    public void register(UIControl uiControl){
        colleagues.add(uiControl);
    }

    public void valueChanged(UIControl control){
        colleagues.stream().filter(c->c!=control).forEach(c->c.controlChanged(c));
    }

}

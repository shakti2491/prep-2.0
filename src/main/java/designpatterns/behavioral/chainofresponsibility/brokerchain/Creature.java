package designpatterns.behavioral.chainofresponsibility.brokerchain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Creature {
    private Game game;
    public  String name;
    public int baseAttack, baseDefense;

    int getAttack(){
       Query q = new Query(name, Query.Argument.ATTACK,baseAttack);
       game.queries.fire(q);
       return q.result;
    }
}

package designpatterns.creational.singleton;

public class EagerSingleton {

    private EagerSingleton(){
        System.out.println("Eager Singleton Constructor");
    }

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return INSTANCE;
    }

}

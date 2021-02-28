package designpatterns.creational.singleton;

public class LazyInitializationHolder {


    private LazyInitializationHolder(){
        System.out.println("LazyInitializationHolder Constructor");
    }

    private static class InitializationHolder{
        static LazyInitializationHolder INSTANCE = new LazyInitializationHolder();
    }

    public static LazyInitializationHolder getInstance(){
        return InitializationHolder.INSTANCE;
    }

    public static void main(String[] args) {
        EagerSingleton singleton = EagerSingleton.getInstance();
    }
}

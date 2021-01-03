package designpatterns.behavioral.chainofresponsibility.middleware;

public interface Server {

    void setMiddleware(Middleware middleware);

    boolean hasEmail(String email);

    boolean isValidPassword(String email, String password);

    boolean logIn(String email, String password);

    void register(String email, String password);
}

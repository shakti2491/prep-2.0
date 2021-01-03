package designpatterns.behavioral.chainofresponsibility.auhtentication.processor;

import designpatterns.behavioral.chainofresponsibility.auhtentication.provider.AuthenticationProvider;

public abstract class AuthenticationProcessor {
    public AuthenticationProcessor nextProcessor;
    // standard constructors
    AuthenticationProcessor(AuthenticationProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }
    public abstract boolean isAuthorized(AuthenticationProvider authProvider);
}

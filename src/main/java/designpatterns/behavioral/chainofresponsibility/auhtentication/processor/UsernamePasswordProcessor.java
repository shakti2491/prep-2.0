package designpatterns.behavioral.chainofresponsibility.auhtentication.processor;

import designpatterns.behavioral.chainofresponsibility.auhtentication.provider.AuthenticationProvider;
import designpatterns.behavioral.chainofresponsibility.auhtentication.provider.UsernamePasswordProvider;

public class UsernamePasswordProcessor extends AuthenticationProcessor {

    public UsernamePasswordProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider authProvider) {
        if (authProvider instanceof UsernamePasswordProvider) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProvider);
        }
        return false;
    }
}

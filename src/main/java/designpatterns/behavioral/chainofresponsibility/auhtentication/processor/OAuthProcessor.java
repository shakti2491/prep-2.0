package designpatterns.behavioral.chainofresponsibility.auhtentication.processor;

import designpatterns.behavioral.chainofresponsibility.auhtentication.provider.AuthenticationProvider;
import designpatterns.behavioral.chainofresponsibility.auhtentication.provider.OAuthTokenProvider;

public class OAuthProcessor extends AuthenticationProcessor {
    public OAuthProcessor(AuthenticationProcessor nextProcessor){
        super(nextProcessor);
    }
    @Override
    public boolean isAuthorized(AuthenticationProvider authProvider) {
        if(authProvider instanceof OAuthTokenProvider)
            return false;
        else if(nextProcessor!=null){
            return nextProcessor.isAuthorized(authProvider);
        }
        return false;
    }
}

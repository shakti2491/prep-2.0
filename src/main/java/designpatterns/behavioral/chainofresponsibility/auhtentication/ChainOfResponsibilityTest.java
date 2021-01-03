package designpatterns.behavioral.chainofresponsibility.auhtentication;

import designpatterns.behavioral.chainofresponsibility.auhtentication.processor.AuthenticationProcessor;
import designpatterns.behavioral.chainofresponsibility.auhtentication.processor.OAuthProcessor;
import designpatterns.behavioral.chainofresponsibility.auhtentication.processor.UsernamePasswordProcessor;
import designpatterns.behavioral.chainofresponsibility.auhtentication.provider.OAuthTokenProvider;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ChainOfResponsibilityTest {
    private static AuthenticationProcessor getChainOfAuthProcessor() {
        AuthenticationProcessor oAuthProcessor = new OAuthProcessor(null);
        return new UsernamePasswordProcessor(oAuthProcessor);
    }

    @Test
    public void givenOAuthProvider_whenCheckingAuthorized_thenSuccess() {
        AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
        assertTrue(authProcessorChain.isAuthorized(new OAuthTokenProvider()));
    }

}

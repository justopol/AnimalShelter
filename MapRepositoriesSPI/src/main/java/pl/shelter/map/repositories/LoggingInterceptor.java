package pl.shelter.map.repositories;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.jboss.logging.Logger;

@Interceptor
@Logging
public class LoggingInterceptor {

    @Inject
    Logger logger;

    @AroundInvoke
    public Object logMethodInvocation(InvocationContext ic) throws Exception {
        logger.info("Rozpoczecie wykonania metody " + ic.getMethod().getName());
        Object proceed = ic.proceed();
        logger.info("Wykonano: " + ic.getMethod().getName());
        return  proceed;
    }
}

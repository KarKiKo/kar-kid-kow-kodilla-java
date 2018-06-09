package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcherAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcherAspect.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logCall() {
        LOGGER.info("processOrder method is calling...");
    }

    @AfterReturning("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logSuccess() {
        LOGGER.info("processOrder has been successfully finished");
    }

    @AfterThrowing("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logFail() {
        LOGGER.info("processOrder has failed");
    }
}

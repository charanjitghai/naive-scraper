package com.cvs.waiter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinearDelayWaiter extends AbstractWaiter implements IWaiter {
    long minDelay = 1000L;

    public LinearDelayWaiter() {
        curDelay = 0;
    }

    public void setThreadContext(ThreadContext threadContext) {
        this.threadContext = threadContext;
    }

    public void vwait() throws InterruptedException {
        curDelay += minDelay;
        super.vwait();
    }
}

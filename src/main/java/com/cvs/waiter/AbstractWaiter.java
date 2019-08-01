package com.cvs.waiter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractWaiter implements IWaiter {

    protected ThreadContext threadContext;
    protected long curDelay;

    public void vwait() throws InterruptedException {
        if (threadContext == null) {
            throw new NullPointerException("ThreadContext must be set before calling wait");
        }
        log.info("{} Sleeping for time {}", threadContext.getExecutionId(), curDelay);
        Thread.sleep(curDelay);
    }

    public void setThreadContext(ThreadContext threadContext) {
        this.threadContext = threadContext;
    }
}

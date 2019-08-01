package com.cvs.waiter;

public interface IWaiter {
    void vwait() throws InterruptedException;
    void setThreadContext(ThreadContext context);
}

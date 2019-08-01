package com.cvs.waiter;

public class ExponentialDelayWaiter extends AbstractWaiter implements IWaiter {

    ExponentialDelayWaiter() {
        this.curDelay = 1000;
    }

    public void vwait() throws InterruptedException {
        super.vwait();
        this.curDelay *= 2;
    }
}

package com.cvs.waiter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConstantDelayWaiter extends AbstractWaiter implements IWaiter {

    ConstantDelayWaiter() {
        this.curDelay = 1000;
    }

    public void vwait() throws InterruptedException {
        super.vwait(); // no update to delay
    }
}

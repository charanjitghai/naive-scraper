package com.cvs;

import com.cvs.processer.ProfileProcesser;
import com.cvs.provider.IProfileProvider;
import com.cvs.provider.SimpleProfileProvider;
import com.cvs.waiter.LinearDelayWaiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Hello world!
 *
 */
@Slf4j
public class App 
{
    public static void main(String[] args) throws Exception {
        IProfileProvider profileProvider = new SimpleProfileProvider();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (String profileUrl : profileProvider.getProfileUrls()) {
            executor.execute(new ProfileProcesser(profileUrl, new LinearDelayWaiter()));
        }
        executor.shutdown();
    }
}

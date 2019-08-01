package com.cvs.processer;

import com.cvs.waiter.IWaiter;
import com.cvs.waiter.ThreadContext;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class ProfileProcesser implements Runnable {
    String profileURL;
    WebDriver driver;
    IWaiter waiter;
    String executionId;
    public ProfileProcesser(String profileURL, IWaiter waiter) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver");
        this.profileURL = profileURL;
        this.driver = new ChromeDriver();
        this.executionId = String.format("ProfileURL: %s, threadId: %s", profileURL, Thread.currentThread().getId());
        waiter.setThreadContext(new ThreadContext(executionId));
        this.waiter = waiter;
    }
    public void run() {
        driver.get(profileURL);
        Document doc  = Jsoup.parse(driver.getPageSource());
        while(doc.text().contains("Log In or Sign Up")) {
            try {
                waiter.vwait();
            } catch (InterruptedException ioe) {
                log.error("{} got interrupted, exiting", this.executionId);
                return;
            }
            driver.get(profileURL);
            doc = Jsoup.parse(driver.getPageSource());
        }
        log.info("{} {} {}", this.executionId, this.profileURL, doc.text());
        driver.quit();
    }
}

package com.FI.FI_Prototype.service;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
public class ScraperService {
    
    private final WebDriver driver;
    private final String url = "https://sbi.co.in/web/personal-banking/investments-deposits/deposits";

    public ScraperService(ChromeDriver driver) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        this.driver = new ChromeDriver(options);
    }

    public String scrapInformation() {

        driver.get(url);
        String rawInfo = driver.findElement(By.tagName("body")).getText();
        return rawInfo;
    }
    public List<WebElement> scrapTags(){
        /*
         * *
         * get the --href-- links and then add to scrap them all. 
         */
        driver.get(url);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        return links;                
    }

    public String printTags(){
        driver.get(url);
        List<WebElement> links = scrapTags();
        String s = "";
        
        for (WebElement link : links){
            System.out.println(link.getAttribute("href"));
            s += link.getAttribute("href") + " ";
        }

        return s;           

       

    }
    
}

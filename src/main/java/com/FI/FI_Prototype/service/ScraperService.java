package com.FI.FI_Prototype.service;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Set <String> scrapTags(){
        driver.get(url);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Set<String> refinedSubPageUrls = new HashSet<>();
        

        for (WebElement link : links) {
            String subPageUrl = link.getAttribute("href");

            if ((subPageUrl != null) && subPageUrl.startsWith(url)){
                subPageUrl = subPageUrl.split("#")[0];
                refinedSubPageUrls.add(subPageUrl);
            }
        }


        return refinedSubPageUrls;                
    }

    public List <String> printTags(){
        driver.get(url);
        // links are obtained  -- done
        List <String> subPageUrls = new ArrayList<>(scrapTags());

        
        List <String> strList = new ArrayList<>();
        
        for (String subPage : subPageUrls){ 
            driver.navigate().to(subPage);
            String rawInfo = driver.findElement(By.tagName("body")).getText();
            strList.add(rawInfo);
        }
        
        return strList;           

       

    }
    
}

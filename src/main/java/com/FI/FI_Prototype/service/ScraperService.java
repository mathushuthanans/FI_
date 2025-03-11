// package com.FI.FI_Prototype.service;

// // for fetch and clean
// import org.jsoup.*;
// import org.jsoup.nodes.Document;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.springframework.stereotype.Service;



// @Service
// public class ScraperService {
    
//     private final WebDriver driver;
//     private final String url = "https://sbi.co.in/web/personal-banking/investments-deposits/govt-schemes";
//     // private final String url = "https://en.wikipedia.org/wiki/JSON";

//     public ScraperService(ChromeDriver driver) {
//         ChromeOptions options = new ChromeOptions();
//         options.addArguments("--headless");
//         options.addArguments("--disable-gpu");
//         options.addArguments("--no-sandbox");

//         this.driver = new ChromeDriver(options);
//     }

//     public List <String> getSubPagesUrls(){
//         driver.get(url);
//         List<WebElement> links = driver.findElements(By.tagName("a"));
//         Set<String> refinedSubPageUrls = new HashSet<>();
        

//         for (WebElement link : links) {
//             String subPageUrl = link.getAttribute("href");

//             if ((subPageUrl != null) && subPageUrl.startsWith(url)){
//                 subPageUrl = subPageUrl.split("#")[0];
//                 refinedSubPageUrls.add(subPageUrl);
//             }
//         }

//         List <String> subPageUrls = new ArrayList<>(refinedSubPageUrls);


//         return subPageUrls;                
//     }

//     public List <String> rawDataFromThePage(){
//         driver.get(url);
//         // links are obtained  -- done
//         List <String> subPageUrls = getSubPagesUrls();

        
//         List <String> strList = new ArrayList<>();
        
//         for (String subPage : subPageUrls){ 
//             driver.navigate().to(subPage);
//             System.out.println(subPage);
//             String rawInfo = driver.findElement(By.tagName("body")).getText();
//             strList.add(rawInfo);
//         }
        
//         return strList;           
//     }

//     public  List <HashMap<String, String>> processRawData(List<String> subPageUrls){
//         HashMap<String, String> processedInfo = new HashMap<>();
//         List <HashMap<String, String>> lstMap = new ArrayList<>();

//         for (String url : subPageUrls){
//             try {

//                 Document doc = Jsoup.connect(url).get();
    
//                 doc.select("nav, footer, aside, script, style").remove(); 
    
//                 String title = doc.title();
//                 String bodyText = doc.body().text();
    
//                 // Identify Key Sections using Headings (h1, h2, h3)
//                 processedInfo.put(title, bodyText);
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//             lstMap.add(processedInfo);

//         }
//         // code to clean the data
//         // code to process / extract the relevant data
//         // add and return the processed Info. 


//         return lstMap;
//     }

    
// }

package com.FI.FI_Prototype.config;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SelenuimConfig {

    @Bean
    public ChromeDriver driver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    
}

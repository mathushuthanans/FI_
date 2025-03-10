package com.FI.FI_Prototype.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.FI.FI_Prototype.service.ScraperService;

@RestController
public class RestHomeController {

    private final ScraperService scraperService;

    public RestHomeController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @GetMapping("/")
    public List <String> scrapInformation() {
        List <String> rawInfo = new ArrayList<>();
        try{
            rawInfo = scraperService.printTags();
        } catch (Exception e){
            e.printStackTrace();
        }

        return rawInfo;
    }
    
}

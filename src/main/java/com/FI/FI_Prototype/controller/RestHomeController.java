package com.FI.FI_Prototype.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
    public List<HashMap<String, String>> scrapInformation() {
        List <String> subPages = new ArrayList<>();
        List <HashMap<String, String>> map = new ArrayList<>();
        try{
            subPages = scraperService.getSubPagesUrls();
            map = scraperService.processRawData(subPages);
        } catch (Exception e){
            e.printStackTrace();
        }


        return map;
    }
    
}

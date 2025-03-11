package com.FI.FI_Prototype.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FI.FI_Prototype.service.FastScarp;
@RestController
public class RestHomeController {

    // private final ScraperService scraperService;
    private final FastScarp fastScarp;

    public RestHomeController(FastScarp fastScarp){
        this.fastScarp = fastScarp;
    }

    // public RestHomeController(ScraperService scraperService) {
    //     this.scraperService = scraperService;
    // }

    // public List<HashMap<String, String>> scrapInformation()
    @GetMapping("/")
    public List <String> scrapInformation() {
        List <String> subPages = new ArrayList<>();
        List <HashMap<String, String>> map = new ArrayList<>();
        String n = null;
        try{
            // subPages = scraperService.getSubPagesUrls();
            // map = scraperService.processRawData(subPages);

            subPages = fastScarp.scarp("https://sbi.co.in/web/personal-banking/investments-deposits/deposits");
            
        } catch (Exception e){
            e.printStackTrace();
        }


        return subPages;
    }
    
}

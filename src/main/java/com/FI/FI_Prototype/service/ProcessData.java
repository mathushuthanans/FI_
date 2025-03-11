package com.FI.FI_Prototype.service;

import java.util.HashMap;

public class ProcessData {
    public HashMap<String, Integer> processRawString(String rawData){
        HashMap<String, Integer> iMap = new HashMap<>();
        String[] parts = rawData.split(" ");
        String[] relevantDataToExtract = {"Eligibility", "Interest Rate", "summary", };

        return iMap;


    }

    
}

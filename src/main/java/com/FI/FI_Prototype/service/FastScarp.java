package com.FI.FI_Prototype.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class FastScarp {
    public List<String> scarp(String url) throws IOException {
        List<String> string = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(5000)
                    .get();

            string.add(doc.body().text());
            Elements links = doc.select("a[href]");

            int count = 0;
            for (Element link : links) {
                if (count >= 5) break; // Limit subpages

                String subpageUrl = link.absUrl("href");
                if (subpageUrl.isEmpty() || !subpageUrl.startsWith("http")) continue;

                try {
                    if (subpageUrl.startsWith(url)){
                        Thread.sleep(1000); // Prevent getting blocked
                        System.out.println(subpageUrl);
                        Document subDoc = Jsoup.connect(subpageUrl).get();
                        string.add(subDoc.body().text());
                        count++;
                    }

                } catch (IOException | InterruptedException e) {
                    System.err.println("Skipping: " + subpageUrl);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load main page: " + url);
        }
        return string;
    }
}

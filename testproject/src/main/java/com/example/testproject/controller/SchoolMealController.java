package com.example.testproject.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import com.example.testproject.service.SchoolMealCrawlerService;
import org.springframework.ui.Model;

@RestController
public class SchoolMealController {

    private final SchoolMealCrawlerService SchoolMealCrawlerService;

    @Autowired
    public SchoolMealController(SchoolMealCrawlerService SchoolMealCrawlerService) {
        this.SchoolMealCrawlerService = SchoolMealCrawlerService;
    }

    @GetMapping("/crawl")
    public String crawlAndSaveData() {
        try {
            return SchoolMealCrawlerService.crawlAndSaveData();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred during crawling and saving data.";
        }
    }

    @GetMapping("/display")
    public String displayData(Model model) {
        // 데이터를 데이터베이스에서 가져오거나 다른 방식으로 데이터를 설정합니다.
        String data = "Sample Data"; // 예제 데이터

        model.addAttribute("data", data);
        return "data";
    }
}

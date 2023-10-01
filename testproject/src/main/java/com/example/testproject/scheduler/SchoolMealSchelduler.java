package com.example.testproject.scheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchoolMealSchelduler {

    @Scheduled(cron = "0 0 * * * ?") // 매 시간마다 크롤링 작업 실행
    public void crawlData() {
        // 크롤링 작업을 수행하는 코드를 작성
    }
}

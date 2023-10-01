package com.example.testproject.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import net.sourceforge.tess4j.Tesseract;

@Configuration
public class SchoolMealConfig {

    @Bean
    public Tesseract tesseract() {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("path/to/tessdata"); // Tesseract 데이터 경로 설정
        return tesseract;
    }
}
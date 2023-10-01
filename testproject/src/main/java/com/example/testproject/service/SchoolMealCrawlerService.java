package com.example.testproject.service;
import com.example.testproject.entity.SchoolMealEntity;
import com.example.testproject.repository.SchoolMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class SchoolMealCrawlerService {

    private final SchoolMealRepository dataRepository;

    @Autowired
    public SchoolMealCrawlerService(SchoolMealRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public String crawlAndSaveData() throws IOException {
        // 웹 페이지에서 이미지 URL을 크롤링
        Document doc = Jsoup.connect("https://web.kangnam.ac.kr/menu/board/info/e4058249224f49ab163131ce104214fb.do?encMenuSeq=6583b62b7f31b68788e66e9b0788e192&encMenuBoardSeq=f5978f94db2d93dc210ee65a257b7249").get();
        String imageUrl = doc.select("img").attr("src");

        // 이미지를 OCR을 통해 텍스트로 추출
        File imageFile = new File("path/to/image.jpg");
        String text = performOCR(imageFile);

        // 데이터베이스에 저장
        SchoolMealEntity dataEntity = new SchoolMealEntity();
        dataEntity.setImageUrl(imageUrl);
        dataEntity.setTextData(text);
        dataRepository.save(dataEntity);

        return "Data crawled and saved.";
    }

    private String performOCR(File imageFile) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("path/to/tessdata"); // Tesseract 데이터 경로 설정
        try {
            return tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
            return "";
        }
    }
}

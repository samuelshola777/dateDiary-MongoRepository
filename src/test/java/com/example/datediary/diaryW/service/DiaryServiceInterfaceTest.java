package com.example.datediary.diaryW.service;

import com.example.datediary.Date.data.model.DiaryDate;
import com.example.datediary.diaryW.diaryExeption.DiaryDateExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryMonthExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryYearExeption;
import com.example.datediary.diaryW.dto.DiaryRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class DiaryServiceInterfaceTest {
@Autowired
    DiaryServiceInterface diaryService;
DiaryRequest diaryRequest1;
DiaryRequest diaryRequest2;
DiaryRequest diaryRequest3;
DiaryRequest diaryRequest4;
DiaryDate date1;
DiaryDate date2;
DiaryDate date3;
DiaryDate date4;
    @BeforeEach
    @Test
    void setUp() throws DiaryMonthExeption, DiaryYearExeption, DiaryDateExeption {
        date1 = new DiaryDate("6","7","2022");
        date2 = new DiaryDate("4","9","22");
        date3 = new DiaryDate("2","5","22");
        date4 = new DiaryDate("7","10","23");

        diaryRequest1 = new DiaryRequest();
        diaryRequest1.setDate(date1);
        diaryRequest1.setIdentifier("Eagle");
        diaryRequest1.setTitle("the way i started java Script");
        diaryRequest1.setBody("the class was given a task in java Script ");

        diaryRequest2 = new DiaryRequest();
        diaryRequest2.setDate(date2);
        diaryRequest2.setIdentifier("horse");
        diaryRequest2.setTitle("how downloaded webStorm");
        diaryRequest2.setBody("after downloading webStorm, i just got seek of front end ");

        diaryRequest3 = new DiaryRequest();
        diaryRequest3.setDate(date3);
        diaryRequest3.setIdentifier("cow");
        diaryRequest3.setTitle("Love for Semi-Colon");
        diaryRequest3.setBody("i and wunmi went to and other coding School and we underSTAND THE difrence");

        diaryRequest4 = new DiaryRequest();
        diaryRequest4.setDate(date4);
        diaryRequest4.setIdentifier("fly");
        diaryRequest4.setTitle("just wanna talk to someone");
        diaryRequest4.setBody("been feeling weak and down lately and can't actually point to a reason");
    }



    @AfterEach
    void tearDown() {
      diaryService.deleteAllDiaryWringing();
    }
    @Test
    void testThatWeCanWriteInDiary() throws DiaryExeption {
    diaryService.writeDiary(diaryRequest2);
    assertEquals(1, diaryService.count());
    }
    @Test
    void testThatWeCanFindDiaryPageByIdentifier() throws DiaryExeption {
        diaryService.writeDiary(diaryRequest1);
        diaryService.writeDiary(diaryRequest2);
        diaryService.writeDiary(diaryRequest3);
        diaryService.writeDiary(diaryRequest4);
        assertEquals(4, diaryService.count());
        assertEquals("how downloaded webStorm",diaryService.findDiaryPageByIdentifier("horse").getTitle());
    }
    @Test
    void thatWeCanDeleteAll(){
        diaryService.deleteAllDiaryWringing();
        assertEquals(0,diaryService.count());
    }
@Test
    void testThatWeCanDeleteByIdentifier() throws DiaryExeption {
    diaryService.writeDiary(diaryRequest1);
    diaryService.writeDiary(diaryRequest2);
    diaryService.writeDiary(diaryRequest3);
    diaryService.writeDiary(diaryRequest4);
    assertEquals(4, diaryService.count());
        diaryService.deleteByIdentifier("Eagle");
    assertEquals(3, diaryService.count());
}
@Test
    void testThatWeCanUpDateDiaryPage() throws DiaryExeption {
    diaryService.writeDiary(diaryRequest1);
    diaryService.writeDiary(diaryRequest2);
    diaryService.writeDiary(diaryRequest3);
    diaryService.writeDiary(diaryRequest4);
    assertEquals(4, diaryService.count());
    String update = "i'm hungry";
    diaryService.updateDiaryBody("fly",update);
    assertEquals("been feeling weak and down lately and can't actually point to a reason, "+update, diaryService.findDiaryPageByIdentifier("fly").getBody());
}
@Test
    void testThatWeCanUpDateTitle() throws DiaryExeption {
    String update = "i'm hungry";

    diaryService.writeDiary(diaryRequest2);
    diaryService.writeDiary(diaryRequest3);
    diaryService.writeDiary(diaryRequest4);
    diaryService.writeDiary(diaryRequest1) ;
    assertEquals(4, diaryService.count());

    diaryService.updateTitle("Eagle",update);
  assertEquals("the way i started java Script, "+update, diaryService.findDiaryPageByIdentifier("Eagle").getTitle());
}

}
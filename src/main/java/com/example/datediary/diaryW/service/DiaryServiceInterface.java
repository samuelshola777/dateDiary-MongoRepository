package com.example.datediary.diaryW.service;

import com.example.datediary.diaryW.data.model.Diary;
import com.example.datediary.diaryW.diaryExeption.DiaryDateExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryMonthExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryYearExeption;
import com.example.datediary.diaryW.dto.DiaryRequest;
import com.example.datediary.diaryW.dto.DiaryResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface DiaryServiceInterface {

     String writeOnDiaryPage(String title, String body,
                                   String identifier, String date,
                                   String month, String year)
            throws DiaryMonthExeption, DiaryYearExeption, DiaryDateExeption;
    DiaryResponse writeDiary(DiaryRequest diaryRequest2) throws DiaryExeption;

    int count();

    Diary findDiaryPageByIdentifier(String identifier);

    DiaryResponse deleteAllDiaryWringing();

    String deleteByIdentifier(String identifier);

    DiaryResponse updateDiaryBody(String fly, String update);

    DiaryResponse updateTitle(String eagle, String update);
    List<Diary> viewAllDiaryPage();
}

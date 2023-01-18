package com.example.datediary.diaryW.service;

import com.example.datediary.Date.data.model.DiaryDate;
import com.example.datediary.diaryW.data.model.Diary;
import com.example.datediary.diaryW.data.repository.DiaryRepository;
import com.example.datediary.diaryW.diaryExeption.DiaryDateExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryMonthExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryYearExeption;
import com.example.datediary.diaryW.dto.DiaryRequest;
import com.example.datediary.diaryW.dto.DiaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryServiceInterface {
@Autowired
DiaryRepository diaryRepository;
    @Override
    public DiaryResponse writeDiary(DiaryRequest diaryRequest2) throws DiaryExeption {
        if (diaryRepository.findDiaryPageByIdentifier(diaryRequest2.getIdentifier()) != null){
            throw new DiaryExeption("Diary page already exist please update an existing page");
        }
            Diary diary = diaryMapping(diaryRequest2);
        diaryRepository.save(diary);
            return new DiaryResponse("Diary page created successfully");

    }

    public String writeOnDiaryPage(String title, String body,
                                   String identifier, String date,
                                   String month, String year)
            throws DiaryMonthExeption, DiaryYearExeption, DiaryDateExeption {
        DiaryDate dDate = new DiaryDate(date, month, year);
        Diary diary = new Diary(dDate,identifier, title,  body);
        if (findDiaryPageByIdentifier(identifier) != null){
            throw new DiaryDateExeption("Page Already Exist please update instead");
        }
        diaryRepository.save(diary);
        return "Diary page Created successfully";
    }

    @Override
    public int count() {
        return (int) diaryRepository.count();
    }

    @Override
    public Diary findDiaryPageByIdentifier(String identifier) {
        return diaryRepository.findDiaryPageByIdentifier(identifier);
    }

    @Override
    public DiaryResponse deleteAllDiaryWringing() {
        diaryRepository.deleteAll();
        return new DiaryResponse("all pages deleted successfully ");
    }

    @Override
    public String deleteByIdentifier(String identifier) {
        diaryRepository.deleteByIdentifier(identifier);
        return "delete successfully";
    }

    @Override
    public DiaryResponse updateDiaryBody(String identifier, String update) {
        String space = ", ";
        Diary diary = diaryRepository.findDiaryPageByIdentifier(identifier);
      String get = diary.getBody();
      diary.setBody(get + space + update);
      diaryRepository.save(diary);
        return new DiaryResponse("Diary update completed ");
    }

    @Override
    public DiaryResponse updateTitle(String identifier, String update) {
        String space = ", ";
        Diary diary = diaryRepository.findDiaryPageByIdentifier(identifier);
        String get = diary.getTitle();
        diary.setTitle(get + space + update);
        diaryRepository.save(diary);
        return null;
    }


    public Diary diaryMapping(DiaryRequest diaryRequest2){
        Diary diary = new Diary(diaryRequest2.getDate(),
                diaryRequest2.getIdentifier()
                ,diaryRequest2.getTitle(),
                diaryRequest2.getBody());
        return diary;
    }

public List<Diary> viewAllDiaryPage(){


     return diaryRepository.findAll();
}
}

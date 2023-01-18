package com.example.datediary.diaryW.controller;

import com.example.datediary.diaryW.data.model.Diary;
import com.example.datediary.diaryW.diaryExeption.DiaryExeption;
import com.example.datediary.diaryW.dto.DiaryRequest;
import com.example.datediary.diaryW.dto.DiaryResponse;
import com.example.datediary.diaryW.service.DiaryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiaryController {
    @Autowired
    DiaryServiceInterface diaryService;

    @PostMapping("/api/diary")
    public DiaryResponse writeOnDiaryPage(@RequestBody DiaryRequest diaryRequest) throws DiaryExeption {
        diaryService.writeDiary(diaryRequest);
        return new DiaryResponse("diary page created successfully");
    }
@PostMapping("/api/diary/updateBody")
    public DiaryResponse updateDiaryBody(@PathVariable String identifier ,@PathVariable String updateBody){
        diaryService.updateDiaryBody(identifier, updateBody);
        return new DiaryResponse("Diary Body Update Successful");
    }

    public DiaryResponse updateDiaryTitle(String identifier, String updateTile){
        diaryService.updateTitle(identifier, updateTile);
        return new DiaryResponse("Diary Title Updated successfully");
    }

    @GetMapping("/api/diary/{identifier}")
    public Diary viewDiaryPage(@PathVariable String identifier){
       return diaryService.findDiaryPageByIdentifier(identifier);
    }
    @DeleteMapping("/api/diary/deleteAll")
    public DiaryResponse deleteAllDiaryPage(){
        diaryService.deleteAllDiaryWringing();
        return new DiaryResponse("all pages deleted successfully");
    }
}

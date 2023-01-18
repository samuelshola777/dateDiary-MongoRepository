package com.example.datediary.diaryW.dto;

import com.example.datediary.Date.data.model.DiaryDate;
import lombok.Data;

@Data
public class DiaryRequest {
    private String title;
    private String body;
    private String identifier;
    private DiaryDate date;
}

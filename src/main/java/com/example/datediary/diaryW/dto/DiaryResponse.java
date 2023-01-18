package com.example.datediary.diaryW.dto;

import lombok.Data;

@Data
public class DiaryResponse {
    String message;
    public DiaryResponse(String message){
        this.message = message;
    }
}

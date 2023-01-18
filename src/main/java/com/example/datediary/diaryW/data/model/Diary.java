package com.example.datediary.diaryW.data.model;

import com.example.datediary.Date.data.model.DiaryDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Diary {
    @Id
    private String id;
    private DiaryDate date;
    private String identifier;
    private String title;
    private String body;
    public Diary(DiaryDate date, String identifier, String title, String body) {
        this.date = date;
        this.identifier = identifier;
        this.title = title;
        this.body = body;
    }

    public String toString(){
        return String.format("""
                Page-Date : %s\n
                ---------------------------->
                Page-Identifier : %s \n
                ----------------------------------->
                Page-Title : %s\n
                --------------------------------------------->
                Page-Body : %s
                
                """);
    }
}

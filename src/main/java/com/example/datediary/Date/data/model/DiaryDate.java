package com.example.datediary.Date.data.model;

import com.example.datediary.diaryW.diaryExeption.DiaryDateExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryMonthExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryYearExeption;
import lombok.*;


@NoArgsConstructor
@Data
public class DiaryDate {
    private String date;
    private String month;
    private String year;

    public DiaryDate(String date, String month, String year) throws DiaryDateExeption, DiaryMonthExeption, DiaryYearExeption {
        String zero = "0";

        if ( Integer.parseInt(date) < 0 || Integer.parseInt(date) > 31){
            throw new DiaryDateExeption("you have entered an invalid date");
        }
        if (date.length() < 2){
            date = zero + date;
        }
        this.date = date;
        if (Integer.parseInt(month) < 0 || Integer.parseInt(month) > 12){
            throw new DiaryMonthExeption("you have entered an invalid month ");
        }
        if (month.length() < 2){
            month = zero + month;
        }
        this.month = month;
        String twoNZero = "20";
        if (year.length() < 2 || year.length() > 4 ){
            throw new DiaryYearExeption("you have entered invalid year value");
        }
        if (year.length() < 4 && year.length() == 2){
            year = twoNZero + year;
        }
        this.year = year;
    }


    public void setDate(String date) throws DiaryDateExeption {
        String zero = "0";

        if ( Integer.parseInt(date) < 0 || Integer.parseInt(date) > 31){
            throw new DiaryDateExeption("you have entered an invalid date");
        }
        if (date.length() < 2){
            date = zero + date;
        }
        this.date = date;
    }

    public void setMonth(String month) throws DiaryMonthExeption {
        String zero = "0";
        if (Integer.parseInt(month) < 0 || Integer.parseInt(month) > 12){
            throw new DiaryMonthExeption("you have entered an invalid month ");
        }
        if (month.length() < 2){
            month = zero + month;
        }
        this.month = month;
    }

    public void setYear(String year) throws DiaryYearExeption {
        String twoNZero = "20";
        if (year.length() < 2 || year.length() > 4 ){
            throw new DiaryYearExeption("you have entered invalid year value");
        }
        if (year.length() < 4 && year.length() == 2){
            year = twoNZero + year;
        }
        this.year = year;
    }
    public  String toString(){
        return String.format("Date ->> %s || Month ->> %s || Year ->> %s",date,month,year);
    }


}

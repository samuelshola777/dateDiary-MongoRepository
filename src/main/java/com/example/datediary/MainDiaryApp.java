package com.example.datediary;

import com.example.datediary.diaryW.data.model.Diary;
import com.example.datediary.diaryW.diaryExeption.DiaryDateExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryMonthExeption;
import com.example.datediary.diaryW.diaryExeption.DiaryYearExeption;
import com.example.datediary.diaryW.service.DiaryServiceImpl;
import com.example.datediary.diaryW.service.DiaryServiceInterface;

import java.util.List;
import java.util.Scanner;
//import java.util.List;

public class MainDiaryApp {
    static Scanner scanner = new Scanner(System.in);
    static Scanner intScanner = new Scanner(System.in);
    public static void main(String[] args) throws DiaryMonthExeption, DiaryYearExeption, DiaryDateExeption {
        disPlayMainMenu();
    }

  static    DiaryServiceInterface diaryService = new DiaryServiceImpl();
public static void disPlayMainMenu() throws DiaryMonthExeption, DiaryYearExeption, DiaryDateExeption {
    String show = """
            || WELCOME TO SAMUEL SHOLA'S DIARY("<<<<----------------------------------->>"")||\n\n
            
            1 : to write a new Diary page(🥰🥰🥰🥰)\n
            
            2 : to view a written Diary page(😁😁😁)\n
            
            3 : to view all Diary page (🧜‍♂️🧜‍♂🧜‍🧜)\n‍️
            
            4 : to update the title of a Written Diary page(😎😎)\n
            
            5 : to Update the body of a written Diary page(🤪🤪🤪)\n
            
            6 : to count number diary written pages(👺👺👺)\n
            
            7 : to delete one of the written pages (🥵🥵🥵)\n
            
            8 : to delete all written Diary pages(😈😈😈😈)\n
            
            9 : to Exit The diaty app(🤡🤡🤡🤡)
            
            
            """.toUpperCase();
    System.out.println(show);
 int response  = inputZ();
 theSwitch(response);
}
public static String theSwitch(int response) throws DiaryMonthExeption, DiaryYearExeption, DiaryDateExeption {
    if (response < 0 || response > 9){
        return "you have entered in valid response";
    }
    while (response != 9) {
        switch (response) {
            case 1 -> writeOnDiaryPage();
            case 2 -> viewDiaryPage();
            case 3 -> viewAllDIaryPages();
            case 4 -> updateTitle();
            case 5 -> updateBody();
            case 6 -> countDiaryPages();
            case 7 -> deleteDiaryPageByIdentifier();
            case 8 -> deleteAllDairyPages();
        }
        if (response == 9){
            break;
        }
    }
    return "thanks for using the Diary app";

}

public static String writeOnDiaryPage()
        throws DiaryMonthExeption,
        DiaryYearExeption, DiaryDateExeption {
    try {
print("please enter today's date \n");
String date = input();
print("please enter the current month\n ");
String month = input();
print("please enter the current year\n");
String year = input();
print("please enter your page identifier\n ");
String identifier = input();
        print("enter message title\n");
        String title = input();
print("please enter your message body\n ");
String body = input();

        diaryService.writeOnDiaryPage(title,body,identifier,date,month,year);
    }catch (DiaryMonthExeption |
    DiaryYearExeption | DiaryDateExeption oi){
return "please you're entering invalid value";
    }
    return "page created successfully ";
}

public static Diary viewDiaryPage(){
    print("please enter your identifier\n");
    String identifier = input();
    return diaryService.findDiaryPageByIdentifier(identifier);
}
public static String updateBody(){
    print("please enter your identifier \n");
    String identifier = input();
    print("please enter your Body ");
    String updateBody = input();
    diaryService.updateDiaryBody(identifier, updateBody);
    return "update successful";
}

public static String updateTitle(){
    print("please enter your identifier \n");
    String identifier = input();
    print("please enter your title ");
    String updateTitle = input();
    diaryService.updateTitle(identifier, updateTitle);
    return "update successful";
}

public static List<Diary> viewAllDIaryPages(){
    return diaryService.viewAllDiaryPage();
}

public static String deleteDiaryPageByIdentifier(){
    print("please enter your identifier ");
    String identifier = input();
    diaryService.deleteByIdentifier(identifier);
    return "Diary page deletes successfully";
}

public static String deleteAllDairyPages(){
    diaryService.deleteAllDiaryWringing();
    return "All DIary pages Deleted Successfully";
}
public static String input(){
 String   word = scanner.nextLine();
    return word;
}
public static int inputZ(){
 int   word = intScanner.nextInt();
    return word;
}
public static void print(String word){
    System.out.println(word);
}
public  static int countDiaryPages(){
 return  diaryService.count();
}
}


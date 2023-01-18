package com.example.datediary.diaryW.data.repository;

import com.example.datediary.diaryW.data.model.Diary;
import com.example.datediary.diaryW.dto.DiaryResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DiaryRepository extends MongoRepository <Diary, String> {

    Diary findDiaryPageByIdentifier(String identifier);

   String deleteByIdentifier(String identifier);
}

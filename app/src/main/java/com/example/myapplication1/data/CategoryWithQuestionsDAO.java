package com.example.myapplication1.data;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CategoryWithQuestionsDAO {
    @Query("SELECT * FROM CategoryQuestionCrossRef")
    public List<CategoryWithQuestions> getCategoryWithQuestions();

    @Query("INSERT INTO CategoryQuestionCrossRef (QuestionID, CategoryID) VALUES (:qID, :aID)")
    public void addQuestionCategory(int qID, int aID);

    @Query("DELETE FROM CategoryQuestionCrossRef")
    public void nukeQuestionCategory();
}

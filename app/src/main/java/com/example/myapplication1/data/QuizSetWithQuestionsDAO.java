package com.example.myapplication1.data;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuizSetWithQuestionsDAO {

    @Query("SELECT * FROM QuizSet")
    public List<QuizSetWithQuestions> getQuizSetWithQuestions();
}

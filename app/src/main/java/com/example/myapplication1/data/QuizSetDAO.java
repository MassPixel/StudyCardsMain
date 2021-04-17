package com.example.myapplication1.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomWarnings;

import java.util.List;

@Dao
public interface QuizSetDAO {
    @Query("INSERT INTO QuizSet (QuizSetName, Question) VALUES (:value1, :value2)")
    public void addQuizSet(String value1, String value2);

    @Query("DELETE FROM QuizSet WHERE QuizSetName = :name")
    public void deleteQuizSet(String name);

    @Query("SELECT QuizSetID FROM QuizSet WHERE QuizSetName = :name")
    public int getQuizSetID(String name);

    /*@Query("SELECT Question FROM QuizSet WHERE QuizSetName = :name")
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    public List<Question> getQuizSetQuestions(String name);*/
}

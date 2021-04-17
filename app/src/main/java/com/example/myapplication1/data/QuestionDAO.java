package com.example.myapplication1.data;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Query("INSERT INTO Question (QuestionText, AnswerText, Comfort) VALUES (:question, :answer, :comfort)")
    public void insertQuestion(String question, String answer, int comfort);

    @Query("SELECT QuestionText FROM Question")
    List<String> getAllQuestions();

    @Query("SELECT QuestionID, QuestionText, AnswerText, Comfort FROM Question")
    List<Question> getAllQuestionsComfort();

    @Query("SELECT QuestionID FROM Question WHERE QuestionText = :qText")
    public int getQuestionID(String qText);

    @Query("DELETE FROM Question")
    public void nukeQuestions();

/*
    @Query("UPDATE QuestionText from Question where QuestionText = :QuesionText")
    public void updateQuesstion(String QuestionText);
*/

    @Query("UPDATE Question SET Comfort = :newComfort WHERE QuestionText = :text")
    public void updateComfort(int newComfort, String text);

    @Query("DELETE FROM Question WHERE QuestionText = :text")
    public void deleteQuestion(String text);

    @Query("DELETE FROM Question")
    public void deleteAllQuestions();

}

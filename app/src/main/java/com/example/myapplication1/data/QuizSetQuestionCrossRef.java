package com.example.myapplication1.data;

import androidx.room.Entity;

@Entity(primaryKeys = {"QuestionID", "QuizSetID"})
public class QuizSetQuestionCrossRef {
    public int QuestionID;
    public int QuizSetID;

}

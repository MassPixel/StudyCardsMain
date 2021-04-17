package com.example.myapplication1.data;

import androidx.room.Entity;

@Entity(primaryKeys = {"CategoryID", "QuestionID"})
public class CategoryQuestionCrossRef {
    public int CategoryID;
    public int QuestionID;
}

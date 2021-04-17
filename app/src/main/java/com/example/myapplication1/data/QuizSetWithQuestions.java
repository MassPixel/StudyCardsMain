package com.example.myapplication1.data;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class QuizSetWithQuestions {
    @Embedded public QuizSet quizset;
    @Relation(
            parentColumn = "QuizSetID",
            entityColumn = "QuestionID",
            associateBy = @Junction(QuizSetQuestionCrossRef.class)
    )
    public List<Question> questions;

}

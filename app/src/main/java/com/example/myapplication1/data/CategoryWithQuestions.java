package com.example.myapplication1.data;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class CategoryWithQuestions {
    @Embedded public Category category;
    @Relation(
            parentColumn = "CategoryID",
            entityColumn = "QuestionID",
            associateBy = @Junction(CategoryQuestionCrossRef.class)
    )
    public List<Question> questions;
}

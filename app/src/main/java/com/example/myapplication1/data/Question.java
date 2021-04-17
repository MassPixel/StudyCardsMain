package com.example.myapplication1.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Question {
    @PrimaryKey (autoGenerate = true)
    public int QuestionID;

    @ColumnInfo
    public String QuestionText;

    @ColumnInfo
    public String AnswerText;

    @ColumnInfo
    public int Comfort;

    public String getQuestionText() {
        return QuestionText;
    }

    public String getAnswerText() {
        return AnswerText;
    }

    public int getComfort() {
        return Comfort;
    }

    public Question randomQuestionChooser(List<Question> questions) {
        double completeWeight = 0.0;
        for (Question question : questions) {
            completeWeight += question.getComfort();
        }
        double r = Math.random() * completeWeight;
        double countWeight = 0.0;
        for (Question question : questions) {
            countWeight += question.getComfort();
            if (countWeight >= r) return question;
        }
        throw new RuntimeException("Failed");

    }

}

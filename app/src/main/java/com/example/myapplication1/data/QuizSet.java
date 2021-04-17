package com.example.myapplication1.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class QuizSet {
    @PrimaryKey (autoGenerate = true)
    public int QuizSetID;

    @ColumnInfo
    public String QuizSetName;

    @ColumnInfo
    public int Question;
}

package com.example.myapplication1.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {
    @PrimaryKey (autoGenerate = true)
    public int CategoryID;

    @ColumnInfo
    public String CategoryName;

    @ColumnInfo
    public  String CategoryDescription;
}

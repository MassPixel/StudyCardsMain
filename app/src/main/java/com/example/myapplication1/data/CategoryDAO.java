package com.example.myapplication1.data;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RoomWarnings;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Query("SELECT CategoryName FROM category")
    List<String> getAllCategories();

    @Query("SELECT CategoryID FROM Category WHERE CategoryName = :cName")
    public int getCategoryID(String cName);

    @Update
    public void updateCategory(Category category);

    @Query("INSERT INTO Category (CategoryName, CategoryDescription) VALUES (:value1, :value2)")
    public void insertCategory(String value1, String value2);

    @Query("DELETE FROM Category WHERE CategoryName = :name")
    public void deleteCategory(String name);

    @Query("DELETE FROM Category")
    public void nukeCategory();
}

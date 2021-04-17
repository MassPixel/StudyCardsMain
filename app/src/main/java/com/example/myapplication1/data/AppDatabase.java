package com.example.myapplication1.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Category.class, Question.class, QuizSet.class, CategoryQuestionCrossRef.class, QuizSetQuestionCrossRef.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase appDB;

    public abstract CategoryDAO categoryDAO();

    public abstract QuestionDAO questionDAO();

    public abstract QuizSetDAO quizSetDAO();

    public abstract CategoryWithQuestionsDAO categoryWithQuestionsDAO();

    public abstract QuizSetWithQuestionsDAO quizSetWithQuestionsDAO();

    public static AppDatabase getInstance(Context context) {
        if (null == appDB) {
            appDB = buildDatabaseInstance(context);
        }
        return appDB;
    }

    private static AppDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                "quiz-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public void cleanUp(){
        appDB = null;
    }
}

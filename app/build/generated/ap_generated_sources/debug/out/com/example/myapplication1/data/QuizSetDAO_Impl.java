package com.example.myapplication1.data;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QuizSetDAO_Impl implements QuizSetDAO {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfAddQuizSet;

  private final SharedSQLiteStatement __preparedStmtOfDeleteQuizSet;

  public QuizSetDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfAddQuizSet = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO QuizSet (QuizSetName, Question) VALUES (?, ?)";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteQuizSet = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM QuizSet WHERE QuizSetName = ?";
        return _query;
      }
    };
  }

  @Override
  public void addQuizSet(final String value1, final String value2) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfAddQuizSet.acquire();
    int _argIndex = 1;
    if (value1 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, value1);
    }
    _argIndex = 2;
    if (value2 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, value2);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfAddQuizSet.release(_stmt);
    }
  }

  @Override
  public void deleteQuizSet(final String name) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteQuizSet.acquire();
    int _argIndex = 1;
    if (name == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, name);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteQuizSet.release(_stmt);
    }
  }

  @Override
  public int getQuizSetID(final String name) {
    final String _sql = "SELECT QuizSetID FROM QuizSet WHERE QuizSetName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

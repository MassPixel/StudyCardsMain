package com.example.myapplication1.data;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QuestionDAO_Impl implements QuestionDAO {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfInsertQuestion;

  private final SharedSQLiteStatement __preparedStmtOfNukeQuestions;

  private final SharedSQLiteStatement __preparedStmtOfUpdateComfort;

  private final SharedSQLiteStatement __preparedStmtOfDeleteQuestion;

  public QuestionDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfInsertQuestion = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO Question (QuestionText, AnswerText, Comfort) VALUES (?, ?, ?)";
        return _query;
      }
    };
    this.__preparedStmtOfNukeQuestions = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Question";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateComfort = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Question SET Comfort = ? WHERE QuestionText = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteQuestion = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Question WHERE QuestionText = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertQuestion(final String question, final String answer, final int comfort) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertQuestion.acquire();
    int _argIndex = 1;
    if (question == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, question);
    }
    _argIndex = 2;
    if (answer == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, answer);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, comfort);
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsertQuestion.release(_stmt);
    }
  }

  @Override
  public void nukeQuestions() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfNukeQuestions.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfNukeQuestions.release(_stmt);
    }
  }

  @Override
  public void updateComfort(final int newComfort, final String text) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateComfort.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, newComfort);
    _argIndex = 2;
    if (text == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, text);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateComfort.release(_stmt);
    }
  }

  @Override
  public void deleteQuestion(final String text) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteQuestion.acquire();
    int _argIndex = 1;
    if (text == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, text);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteQuestion.release(_stmt);
    }
  }

  @Override
  public void deleteAllQuestions() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfNukeQuestions.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfNukeQuestions.release(_stmt);
    }
  }

  @Override
  public List<String> getAllQuestions() {
    final String _sql = "SELECT QuestionText FROM Question";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Question> getAllQuestionsComfort() {
    final String _sql = "SELECT QuestionID, QuestionText, AnswerText, Comfort FROM Question";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfQuestionID = CursorUtil.getColumnIndexOrThrow(_cursor, "QuestionID");
      final int _cursorIndexOfQuestionText = CursorUtil.getColumnIndexOrThrow(_cursor, "QuestionText");
      final int _cursorIndexOfAnswerText = CursorUtil.getColumnIndexOrThrow(_cursor, "AnswerText");
      final int _cursorIndexOfComfort = CursorUtil.getColumnIndexOrThrow(_cursor, "Comfort");
      final List<Question> _result = new ArrayList<Question>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Question _item;
        _item = new Question();
        _item.QuestionID = _cursor.getInt(_cursorIndexOfQuestionID);
        _item.QuestionText = _cursor.getString(_cursorIndexOfQuestionText);
        _item.AnswerText = _cursor.getString(_cursorIndexOfAnswerText);
        _item.Comfort = _cursor.getInt(_cursorIndexOfComfort);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getQuestionID(final String qText) {
    final String _sql = "SELECT QuestionID FROM Question WHERE QuestionText = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (qText == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, qText);
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

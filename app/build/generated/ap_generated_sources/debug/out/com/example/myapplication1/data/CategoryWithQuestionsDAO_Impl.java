package com.example.myapplication1.data;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CategoryWithQuestionsDAO_Impl implements CategoryWithQuestionsDAO {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfAddQuestionCategory;

  private final SharedSQLiteStatement __preparedStmtOfNukeQuestionCategory;

  public CategoryWithQuestionsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfAddQuestionCategory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO CategoryQuestionCrossRef (QuestionID, CategoryID) VALUES (?, ?)";
        return _query;
      }
    };
    this.__preparedStmtOfNukeQuestionCategory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM CategoryQuestionCrossRef";
        return _query;
      }
    };
  }

  @Override
  public void addQuestionCategory(final int qID, final int aID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfAddQuestionCategory.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, qID);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, aID);
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfAddQuestionCategory.release(_stmt);
    }
  }

  @Override
  public void nukeQuestionCategory() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfNukeQuestionCategory.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfNukeQuestionCategory.release(_stmt);
    }
  }

  @Override
  public List<CategoryWithQuestions> getCategoryWithQuestions() {
    final String _sql = "SELECT * FROM CategoryQuestionCrossRef";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfCategoryID = CursorUtil.getColumnIndexOrThrow(_cursor, "CategoryID");
      final LongSparseArray<ArrayList<Question>> _collectionQuestions = new LongSparseArray<ArrayList<Question>>();
      while (_cursor.moveToNext()) {
        if (!_cursor.isNull(_cursorIndexOfCategoryID)) {
          final long _tmpKey = _cursor.getLong(_cursorIndexOfCategoryID);
          ArrayList<Question> _tmpQuestionsCollection = _collectionQuestions.get(_tmpKey);
          if (_tmpQuestionsCollection == null) {
            _tmpQuestionsCollection = new ArrayList<Question>();
            _collectionQuestions.put(_tmpKey, _tmpQuestionsCollection);
          }
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshipQuestionAscomExampleMyapplication1DataQuestion(_collectionQuestions);
      final List<CategoryWithQuestions> _result = new ArrayList<CategoryWithQuestions>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CategoryWithQuestions _item;
        final Category _tmpCategory;
        if (! (_cursor.isNull(_cursorIndexOfCategoryID))) {
          _tmpCategory = new Category();
          _tmpCategory.CategoryID = _cursor.getInt(_cursorIndexOfCategoryID);
        }  else  {
          _tmpCategory = null;
        }
        ArrayList<Question> _tmpQuestionsCollection_1 = null;
        if (!_cursor.isNull(_cursorIndexOfCategoryID)) {
          final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfCategoryID);
          _tmpQuestionsCollection_1 = _collectionQuestions.get(_tmpKey_1);
        }
        if (_tmpQuestionsCollection_1 == null) {
          _tmpQuestionsCollection_1 = new ArrayList<Question>();
        }
        _item = new CategoryWithQuestions();
        _item.category = _tmpCategory;
        _item.questions = _tmpQuestionsCollection_1;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  private void __fetchRelationshipQuestionAscomExampleMyapplication1DataQuestion(final LongSparseArray<ArrayList<Question>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<Question>> _tmpInnerMap = new LongSparseArray<ArrayList<Question>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipQuestionAscomExampleMyapplication1DataQuestion(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<Question>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipQuestionAscomExampleMyapplication1DataQuestion(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `Question`.`QuestionID` AS `QuestionID`,`Question`.`QuestionText` AS `QuestionText`,`Question`.`AnswerText` AS `AnswerText`,`Question`.`Comfort` AS `Comfort`,_junction.`CategoryID` FROM `CategoryQuestionCrossRef` AS _junction INNER JOIN `Question` ON (_junction.`QuestionID` = `Question`.`QuestionID`) WHERE _junction.`CategoryID` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = 4; // _junction.CategoryID;
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfQuestionID = CursorUtil.getColumnIndex(_cursor, "QuestionID");
      final int _cursorIndexOfQuestionText = CursorUtil.getColumnIndex(_cursor, "QuestionText");
      final int _cursorIndexOfAnswerText = CursorUtil.getColumnIndex(_cursor, "AnswerText");
      final int _cursorIndexOfComfort = CursorUtil.getColumnIndex(_cursor, "Comfort");
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final long _tmpKey = _cursor.getLong(_itemKeyIndex);
          ArrayList<Question> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final Question _item_1;
            _item_1 = new Question();
            if (_cursorIndexOfQuestionID != -1) {
              _item_1.QuestionID = _cursor.getInt(_cursorIndexOfQuestionID);
            }
            if (_cursorIndexOfQuestionText != -1) {
              _item_1.QuestionText = _cursor.getString(_cursorIndexOfQuestionText);
            }
            if (_cursorIndexOfAnswerText != -1) {
              _item_1.AnswerText = _cursor.getString(_cursorIndexOfAnswerText);
            }
            if (_cursorIndexOfComfort != -1) {
              _item_1.Comfort = _cursor.getInt(_cursorIndexOfComfort);
            }
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}

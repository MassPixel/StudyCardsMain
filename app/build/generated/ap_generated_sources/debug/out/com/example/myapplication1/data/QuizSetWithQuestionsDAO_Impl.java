package com.example.myapplication1.data;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QuizSetWithQuestionsDAO_Impl implements QuizSetWithQuestionsDAO {
  private final RoomDatabase __db;

  public QuizSetWithQuestionsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public List<QuizSetWithQuestions> getQuizSetWithQuestions() {
    final String _sql = "SELECT * FROM QuizSet";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfQuizSetID = CursorUtil.getColumnIndexOrThrow(_cursor, "QuizSetID");
      final int _cursorIndexOfQuizSetName = CursorUtil.getColumnIndexOrThrow(_cursor, "QuizSetName");
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "Question");
      final LongSparseArray<ArrayList<Question>> _collectionQuestions = new LongSparseArray<ArrayList<Question>>();
      while (_cursor.moveToNext()) {
        if (!_cursor.isNull(_cursorIndexOfQuizSetID)) {
          final long _tmpKey = _cursor.getLong(_cursorIndexOfQuizSetID);
          ArrayList<Question> _tmpQuestionsCollection = _collectionQuestions.get(_tmpKey);
          if (_tmpQuestionsCollection == null) {
            _tmpQuestionsCollection = new ArrayList<Question>();
            _collectionQuestions.put(_tmpKey, _tmpQuestionsCollection);
          }
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshipQuestionAscomExampleMyapplication1DataQuestion(_collectionQuestions);
      final List<QuizSetWithQuestions> _result = new ArrayList<QuizSetWithQuestions>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final QuizSetWithQuestions _item;
        final QuizSet _tmpQuizset;
        if (! (_cursor.isNull(_cursorIndexOfQuizSetID) && _cursor.isNull(_cursorIndexOfQuizSetName) && _cursor.isNull(_cursorIndexOfQuestion))) {
          _tmpQuizset = new QuizSet();
          _tmpQuizset.QuizSetID = _cursor.getInt(_cursorIndexOfQuizSetID);
          _tmpQuizset.QuizSetName = _cursor.getString(_cursorIndexOfQuizSetName);
          _tmpQuizset.Question = _cursor.getInt(_cursorIndexOfQuestion);
        }  else  {
          _tmpQuizset = null;
        }
        ArrayList<Question> _tmpQuestionsCollection_1 = null;
        if (!_cursor.isNull(_cursorIndexOfQuizSetID)) {
          final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfQuizSetID);
          _tmpQuestionsCollection_1 = _collectionQuestions.get(_tmpKey_1);
        }
        if (_tmpQuestionsCollection_1 == null) {
          _tmpQuestionsCollection_1 = new ArrayList<Question>();
        }
        _item = new QuizSetWithQuestions();
        _item.quizset = _tmpQuizset;
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
    _stringBuilder.append("SELECT `Question`.`QuestionID` AS `QuestionID`,`Question`.`QuestionText` AS `QuestionText`,`Question`.`AnswerText` AS `AnswerText`,`Question`.`Comfort` AS `Comfort`,_junction.`QuizSetID` FROM `QuizSetQuestionCrossRef` AS _junction INNER JOIN `Question` ON (_junction.`QuestionID` = `Question`.`QuestionID`) WHERE _junction.`QuizSetID` IN (");
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
      final int _itemKeyIndex = 4; // _junction.QuizSetID;
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

package com.example.myapplication1.data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CategoryDAO _categoryDAO;

  private volatile QuestionDAO _questionDAO;

  private volatile QuizSetDAO _quizSetDAO;

  private volatile CategoryWithQuestionsDAO _categoryWithQuestionsDAO;

  private volatile QuizSetWithQuestionsDAO _quizSetWithQuestionsDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Category` (`CategoryID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `CategoryName` TEXT, `CategoryDescription` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Question` (`QuestionID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `QuestionText` TEXT, `AnswerText` TEXT, `Comfort` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `QuizSet` (`QuizSetID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `QuizSetName` TEXT, `Question` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CategoryQuestionCrossRef` (`CategoryID` INTEGER NOT NULL, `QuestionID` INTEGER NOT NULL, PRIMARY KEY(`CategoryID`, `QuestionID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `QuizSetQuestionCrossRef` (`QuestionID` INTEGER NOT NULL, `QuizSetID` INTEGER NOT NULL, PRIMARY KEY(`QuestionID`, `QuizSetID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '54796a0188700033c8bcba68f355c1a8')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Category`");
        _db.execSQL("DROP TABLE IF EXISTS `Question`");
        _db.execSQL("DROP TABLE IF EXISTS `QuizSet`");
        _db.execSQL("DROP TABLE IF EXISTS `CategoryQuestionCrossRef`");
        _db.execSQL("DROP TABLE IF EXISTS `QuizSetQuestionCrossRef`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCategory = new HashMap<String, TableInfo.Column>(3);
        _columnsCategory.put("CategoryID", new TableInfo.Column("CategoryID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("CategoryName", new TableInfo.Column("CategoryName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("CategoryDescription", new TableInfo.Column("CategoryDescription", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategory = new TableInfo("Category", _columnsCategory, _foreignKeysCategory, _indicesCategory);
        final TableInfo _existingCategory = TableInfo.read(_db, "Category");
        if (! _infoCategory.equals(_existingCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "Category(com.example.myapplication1.data.Category).\n"
                  + " Expected:\n" + _infoCategory + "\n"
                  + " Found:\n" + _existingCategory);
        }
        final HashMap<String, TableInfo.Column> _columnsQuestion = new HashMap<String, TableInfo.Column>(4);
        _columnsQuestion.put("QuestionID", new TableInfo.Column("QuestionID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("QuestionText", new TableInfo.Column("QuestionText", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("AnswerText", new TableInfo.Column("AnswerText", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("Comfort", new TableInfo.Column("Comfort", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuestion = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuestion = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuestion = new TableInfo("Question", _columnsQuestion, _foreignKeysQuestion, _indicesQuestion);
        final TableInfo _existingQuestion = TableInfo.read(_db, "Question");
        if (! _infoQuestion.equals(_existingQuestion)) {
          return new RoomOpenHelper.ValidationResult(false, "Question(com.example.myapplication1.data.Question).\n"
                  + " Expected:\n" + _infoQuestion + "\n"
                  + " Found:\n" + _existingQuestion);
        }
        final HashMap<String, TableInfo.Column> _columnsQuizSet = new HashMap<String, TableInfo.Column>(3);
        _columnsQuizSet.put("QuizSetID", new TableInfo.Column("QuizSetID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuizSet.put("QuizSetName", new TableInfo.Column("QuizSetName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuizSet.put("Question", new TableInfo.Column("Question", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuizSet = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuizSet = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuizSet = new TableInfo("QuizSet", _columnsQuizSet, _foreignKeysQuizSet, _indicesQuizSet);
        final TableInfo _existingQuizSet = TableInfo.read(_db, "QuizSet");
        if (! _infoQuizSet.equals(_existingQuizSet)) {
          return new RoomOpenHelper.ValidationResult(false, "QuizSet(com.example.myapplication1.data.QuizSet).\n"
                  + " Expected:\n" + _infoQuizSet + "\n"
                  + " Found:\n" + _existingQuizSet);
        }
        final HashMap<String, TableInfo.Column> _columnsCategoryQuestionCrossRef = new HashMap<String, TableInfo.Column>(2);
        _columnsCategoryQuestionCrossRef.put("CategoryID", new TableInfo.Column("CategoryID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoryQuestionCrossRef.put("QuestionID", new TableInfo.Column("QuestionID", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategoryQuestionCrossRef = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategoryQuestionCrossRef = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategoryQuestionCrossRef = new TableInfo("CategoryQuestionCrossRef", _columnsCategoryQuestionCrossRef, _foreignKeysCategoryQuestionCrossRef, _indicesCategoryQuestionCrossRef);
        final TableInfo _existingCategoryQuestionCrossRef = TableInfo.read(_db, "CategoryQuestionCrossRef");
        if (! _infoCategoryQuestionCrossRef.equals(_existingCategoryQuestionCrossRef)) {
          return new RoomOpenHelper.ValidationResult(false, "CategoryQuestionCrossRef(com.example.myapplication1.data.CategoryQuestionCrossRef).\n"
                  + " Expected:\n" + _infoCategoryQuestionCrossRef + "\n"
                  + " Found:\n" + _existingCategoryQuestionCrossRef);
        }
        final HashMap<String, TableInfo.Column> _columnsQuizSetQuestionCrossRef = new HashMap<String, TableInfo.Column>(2);
        _columnsQuizSetQuestionCrossRef.put("QuestionID", new TableInfo.Column("QuestionID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuizSetQuestionCrossRef.put("QuizSetID", new TableInfo.Column("QuizSetID", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuizSetQuestionCrossRef = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuizSetQuestionCrossRef = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuizSetQuestionCrossRef = new TableInfo("QuizSetQuestionCrossRef", _columnsQuizSetQuestionCrossRef, _foreignKeysQuizSetQuestionCrossRef, _indicesQuizSetQuestionCrossRef);
        final TableInfo _existingQuizSetQuestionCrossRef = TableInfo.read(_db, "QuizSetQuestionCrossRef");
        if (! _infoQuizSetQuestionCrossRef.equals(_existingQuizSetQuestionCrossRef)) {
          return new RoomOpenHelper.ValidationResult(false, "QuizSetQuestionCrossRef(com.example.myapplication1.data.QuizSetQuestionCrossRef).\n"
                  + " Expected:\n" + _infoQuizSetQuestionCrossRef + "\n"
                  + " Found:\n" + _existingQuizSetQuestionCrossRef);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "54796a0188700033c8bcba68f355c1a8", "0cb4201ab94c37aed9fb81096b0459c4");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Category","Question","QuizSet","CategoryQuestionCrossRef","QuizSetQuestionCrossRef");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Category`");
      _db.execSQL("DELETE FROM `Question`");
      _db.execSQL("DELETE FROM `QuizSet`");
      _db.execSQL("DELETE FROM `CategoryQuestionCrossRef`");
      _db.execSQL("DELETE FROM `QuizSetQuestionCrossRef`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CategoryDAO categoryDAO() {
    if (_categoryDAO != null) {
      return _categoryDAO;
    } else {
      synchronized(this) {
        if(_categoryDAO == null) {
          _categoryDAO = new CategoryDAO_Impl(this);
        }
        return _categoryDAO;
      }
    }
  }

  @Override
  public QuestionDAO questionDAO() {
    if (_questionDAO != null) {
      return _questionDAO;
    } else {
      synchronized(this) {
        if(_questionDAO == null) {
          _questionDAO = new QuestionDAO_Impl(this);
        }
        return _questionDAO;
      }
    }
  }

  @Override
  public QuizSetDAO quizSetDAO() {
    if (_quizSetDAO != null) {
      return _quizSetDAO;
    } else {
      synchronized(this) {
        if(_quizSetDAO == null) {
          _quizSetDAO = new QuizSetDAO_Impl(this);
        }
        return _quizSetDAO;
      }
    }
  }

  @Override
  public CategoryWithQuestionsDAO categoryWithQuestionsDAO() {
    if (_categoryWithQuestionsDAO != null) {
      return _categoryWithQuestionsDAO;
    } else {
      synchronized(this) {
        if(_categoryWithQuestionsDAO == null) {
          _categoryWithQuestionsDAO = new CategoryWithQuestionsDAO_Impl(this);
        }
        return _categoryWithQuestionsDAO;
      }
    }
  }

  @Override
  public QuizSetWithQuestionsDAO quizSetWithQuestionsDAO() {
    if (_quizSetWithQuestionsDAO != null) {
      return _quizSetWithQuestionsDAO;
    } else {
      synchronized(this) {
        if(_quizSetWithQuestionsDAO == null) {
          _quizSetWithQuestionsDAO = new QuizSetWithQuestionsDAO_Impl(this);
        }
        return _quizSetWithQuestionsDAO;
      }
    }
  }
}

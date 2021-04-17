package com.example.myapplication1.data;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CategoryDAO_Impl implements CategoryDAO {
  private final RoomDatabase __db;

  private final EntityDeletionOrUpdateAdapter<Category> __updateAdapterOfCategory;

  private final SharedSQLiteStatement __preparedStmtOfInsertCategory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCategory;

  private final SharedSQLiteStatement __preparedStmtOfNukeCategory;

  public CategoryDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__updateAdapterOfCategory = new EntityDeletionOrUpdateAdapter<Category>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Category` SET `CategoryID` = ?,`CategoryName` = ?,`CategoryDescription` = ? WHERE `CategoryID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
        stmt.bindLong(1, value.CategoryID);
        if (value.CategoryName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.CategoryName);
        }
        if (value.CategoryDescription == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.CategoryDescription);
        }
        stmt.bindLong(4, value.CategoryID);
      }
    };
    this.__preparedStmtOfInsertCategory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO Category (CategoryName, CategoryDescription) VALUES (?, ?)";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCategory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Category WHERE CategoryName = ?";
        return _query;
      }
    };
    this.__preparedStmtOfNukeCategory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Category";
        return _query;
      }
    };
  }

  @Override
  public void updateCategory(final Category category) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCategory.handle(category);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertCategory(final String value1, final String value2) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertCategory.acquire();
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
      __preparedStmtOfInsertCategory.release(_stmt);
    }
  }

  @Override
  public void deleteCategory(final String name) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCategory.acquire();
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
      __preparedStmtOfDeleteCategory.release(_stmt);
    }
  }

  @Override
  public void nukeCategory() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfNukeCategory.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfNukeCategory.release(_stmt);
    }
  }

  @Override
  public List<String> getAllCategories() {
    final String _sql = "SELECT CategoryName FROM category";
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
  public int getCategoryID(final String cName) {
    final String _sql = "SELECT CategoryID FROM Category WHERE CategoryName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cName);
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

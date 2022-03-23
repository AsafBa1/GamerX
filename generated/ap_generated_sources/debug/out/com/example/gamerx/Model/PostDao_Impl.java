package com.example.gamerx.Model;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PostDao_Impl implements PostDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Post> __insertionAdapterOfPost;

  private final EntityDeletionOrUpdateAdapter<Post> __deletionAdapterOfPost;

  public PostDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPost = new EntityInsertionAdapter<Post>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Post` (`Id`,`Title`,`Body`,`UserId`,`avatarUrl`,`updateDate`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Post value) {
        if (value.Id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.Id);
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.Body == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.Body);
        }
        if (value.getUserId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserId());
        }
        if (value.getAvatarUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAvatarUrl());
        }
        if (value.getUpdateDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getUpdateDate());
        }
      }
    };
    this.__deletionAdapterOfPost = new EntityDeletionOrUpdateAdapter<Post>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Post` WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Post value) {
        if (value.Id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.Id);
        }
      }
    };
  }

  @Override
  public void insertAll(final Post... posts) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPost.insert(posts);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Post posts) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPost.handle(posts);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Post> getAll() {
    final String _sql = "select * from Post";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "Title");
      final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "Body");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "UserId");
      final int _cursorIndexOfAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarUrl");
      final int _cursorIndexOfUpdateDate = CursorUtil.getColumnIndexOrThrow(_cursor, "updateDate");
      final List<Post> _result = new ArrayList<Post>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Post _item;
        _item = new Post();
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        if (_cursor.isNull(_cursorIndexOfBody)) {
          _item.Body = null;
        } else {
          _item.Body = _cursor.getString(_cursorIndexOfBody);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.UserId = null;
        } else {
          _item.UserId = _cursor.getString(_cursorIndexOfUserId);
        }
        final String _tmpAvatarUrl;
        if (_cursor.isNull(_cursorIndexOfAvatarUrl)) {
          _tmpAvatarUrl = null;
        } else {
          _tmpAvatarUrl = _cursor.getString(_cursorIndexOfAvatarUrl);
        }
        _item.setAvatarUrl(_tmpAvatarUrl);
        final Long _tmpUpdateDate;
        if (_cursor.isNull(_cursorIndexOfUpdateDate)) {
          _tmpUpdateDate = null;
        } else {
          _tmpUpdateDate = _cursor.getLong(_cursorIndexOfUpdateDate);
        }
        _item.setUpdateDate(_tmpUpdateDate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

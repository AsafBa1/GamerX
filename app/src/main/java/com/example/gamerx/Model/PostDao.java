package com.example.gamerx.Model;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class PostDao {
    @Query("select * from Post")
    abstract List<Post> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertAll(Post... posts);

    @Delete
    abstract void delete(Post posts);
}

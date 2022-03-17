package com.example.gamerx.Model;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gamerx.BaseActivity;
import com.example.gamerx.MyApplication;

@Database(entities = {Post.class}, version = 1)
abstract class AppLocalDbRepository extends RoomDatabase {
    public abstract PostDao studentDao();
}
public class AppLocalDb{
   static public AppLocalDbRepository db =
            Room.databaseBuilder(MyApplication.getContext(),
                    AppLocalDbRepository.class,
                    "dbFileName.db")
                    .fallbackToDestructiveMigration()
                    .build();
}

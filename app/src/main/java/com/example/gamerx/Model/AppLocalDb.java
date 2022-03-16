package com.example.gamerx.Model;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gamerx.BaseActivity;

@Database(entities = {Post.class}, version = 1)
abstract class AppLocalDbRepository extends RoomDatabase {
    public abstract PostDao studentDao();
}
public class AppLocalDb{
   // static public AppLocalDbRepository db =
            //Room.databaseBuilder(BaseActivity.context,
                   // AppLocalDbRepository.class,
                   // "dbFileName.db")
                   // .fallbackToDestructiveMigration()
                   // .build();
}

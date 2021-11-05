package com.example.bookland.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class},version = 2)
public abstract class BookDatabase extends RoomDatabase {

    private static BookDatabase instance;

    public static BookDatabase getInstance(Context context) {
        if(instance == null){
            instance =  Room.databaseBuilder(context, BookDatabase.class, "Books").build();
        }
        return instance;
    }

    public abstract BookItemDao getDao();


}

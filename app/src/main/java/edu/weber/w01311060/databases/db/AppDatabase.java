package edu.weber.w01311060.databases.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.weber.w01311060.databases.models.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context)
    {
        if(instance != null)
        {
            return instance;
        }
        instance = Room.databaseBuilder(context, AppDatabase.class, "user-database").build();
        return instance;
    }

    public abstract UserDAO getUserDao();
}

package edu.weber.w01311060.databases;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.weber.w01311060.databases.db.AppDatabase;
import edu.weber.w01311060.databases.models.User;

public class UserViewModel extends ViewModel
{

    private LiveData<List<User>> userList;

    public LiveData<List<User>> getAllUsers(Context context)
    {
        if(userList == null)
        {
            userList = AppDatabase.getInstance(context).getUserDao().getAll();
        }
        return userList;
    }
}

package edu.weber.w01311060.databases.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.weber.w01311060.databases.models.User;

@Dao
public interface UserDAO
{
    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM User WHERE userID = :id")
    User findUserByUserId(int id);

    @Delete
    void deleteUser(User user);

    @Insert
    void insertUsers(User... user);

    @Update //Must be an object retrieved from the database (Can't just create a new User)
    void updateUser(User user);
}

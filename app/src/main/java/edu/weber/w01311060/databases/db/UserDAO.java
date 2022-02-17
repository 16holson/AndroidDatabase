package edu.weber.w01311060.databases.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.weber.w01311060.databases.models.User;

@Dao
public interface UserDAO
{
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE userID = :id")
    User findUserByUserId(int id);

    @Delete
    void deleteUser(User user);

    @Insert
    void insertUsers(User... user);
}

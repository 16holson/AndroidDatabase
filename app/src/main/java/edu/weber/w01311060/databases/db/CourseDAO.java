package edu.weber.w01311060.databases.db;

import androidx.room.Dao;
import androidx.room.Insert;

import edu.weber.w01311060.databases.models.Course;

@Dao
public interface CourseDAO
{
    @Insert
    public void insertAll(Course... courses);
}

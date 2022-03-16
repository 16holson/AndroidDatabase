package edu.weber.w01311060.databases.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course
{
    @PrimaryKey(autoGenerate = true)
    public int _id;

    @ColumnInfo
    public String start_at;
    @ColumnInfo
    public String end_at;
    @ColumnInfo
    public String name;
    @ColumnInfo
    public String id;
    @ColumnInfo
    public String course_code;

    public String getStart_at()
    {
        return start_at;
    }

    public void setStart_at(String start_at)
    {
        this.start_at = start_at;
    }

    public String getEnd_at()
    {
        return end_at;
    }

    public void setEnd_at(String end_at)
    {
        this.end_at = end_at;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCourse_code()
    {
        return course_code;
    }

    public void setCourse_code(String course_code)
    {
        this.course_code = course_code;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "start_at='" + start_at + '\'' +
                ", end_at='" + end_at + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", course_code='" + course_code + '\'' +
                '}';
    }
}

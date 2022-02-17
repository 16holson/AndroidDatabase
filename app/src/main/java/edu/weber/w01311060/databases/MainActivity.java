package edu.weber.w01311060.databases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.weber.w01311060.databases.db.AppDatabase;
import edu.weber.w01311060.databases.models.User;

public class MainActivity extends AppCompatActivity
{
    /*
        add def room_version = "2.4.1" ,
        implementation "androidx.room:room-runtime:$room_version"
        annotationProcessor "androidx.room:room-compiler:$room_version"
        to build.gradle(app)
     */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                AppDatabase.getInstance(getApplicationContext())
                           .getUserDao()
                           .insertUsers(new User("Hunter", "Olson")); //getContext() when in fragment
            }
        }).start();
    }

    //do in fragment not the main activity this is only for demonstration purposes


}
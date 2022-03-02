package edu.weber.w01311060.databases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

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

//        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                FullScreenDialog dialog = new FullScreenDialog();
//                dialog.show(getSupportFragmentManager(), "dialog");
//            }
//        });

        new ViewModelProvider(this) //Define ownership
                .get(UserViewModel.class) //returns View Model Instance
                .getAllUsers(getApplicationContext()) //getContext() when in fragment (returns LiveData)
                .observe(this, new Observer<List<User>>()
                {
                    @Override
                    public void onChanged(List<User> users)
                    {
                        Log.d("ActivityObserver", users.toString());
                    }
                });
    }

    //do in fragment not the main activity this is only for demonstration purposes


}
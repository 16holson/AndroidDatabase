package edu.weber.w01311060.databases;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import edu.weber.w01311060.databases.db.AppDatabase;
import edu.weber.w01311060.databases.models.Course;

public class GetCoursesTask extends AsyncTask<Context, Integer, String>
{
    private String json = "";
    private Context context;

    @Override
    protected String doInBackground(Context... params)
    {
        Log.d("Task", "Executing in background");
        //Log.d("Task", "Param 0: " + params[0]);
        this.context = params[0];

        try
        {
            URL url = new URL("https://weber.instructure.com/api/v1/courses");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + Authorization.token); //bearer token have to add a Authorization.java class
            connection.connect();

            int status = connection.getResponseCode();
            Log.d("Task", "status " + status);

            switch (status)
            {
                case 200:
                case 201:
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    json = reader.readLine();
                    Log.d("Task", "json: " + json);
                    return json;
                default:
                    //TODO:Handle Failure
            }

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
            Log.d("Task", "URL Malformed: " + e.getMessage());
        }
        catch (IOException e)
        {
            Log.d("Task", "IOException: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);

        Course[] courses = jsonParse(json);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                AppDatabase.getInstance(context)
                        .getCourseDao()
                        .insertAll(courses);

            }
        }).start();

    }

    private Course[] jsonParse(String rawJson)
    {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        Course[] courses = null;

        try
        {
            courses = gson.fromJson(rawJson, Course[].class);
            Log.d("Task", "Courses Length: " + courses.length);
        }
        catch (Exception e)
        {
            Log.d("Task", "Error converting json: " + e.getMessage());
        }

        return courses;
    }
}

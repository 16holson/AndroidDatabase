package edu.weber.w01311060.databases;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetCoursesTask extends AsyncTask<String, Integer, String>
{

    @Override
    protected String doInBackground(String... params)
    {
        Log.d("Task", "Executing in background");
        Log.d("Task", "Param 0: " + params[0]);

        try
        {
            URL url = new URL("https://weber.instructure.com/api/v1/courses");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + Authorization.token); //bearer token
            connection.connect();

            int status = connection.getResponseCode();
            Log.d("Task", "status " + status);

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
}

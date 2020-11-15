package com.example.productivitycac;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

//imports needed to read into the JSON file
//manages list for all to do lists so that the page updates whenever returning there



public class ListManager {

    //TODO: figure out how to parse information to list
    public static Map listManager = new HashMap<String, ArrayList<Object>>();
    public static Map allTasks = new HashMap<String, ArrayList<Double>>();
    public ListManager()
    {

        // typecasting obj to JSONObject

    }
    /*
        Structure:
        listManager:
            <String>: get list by it's name (string)
            <ArrayList<Object>: each list of tasks
                each list of tasks: {[task, duration], [task, duration]};
                    duration: once done, add task name and duration to 'all tasks' map
                               makes it so any task can be in any list and still get averaged for time
        allTasks: stores name and duration[] for all tasks as a record for averaging times

     */

    /*
        saves information to a file called list manager
        list manager stores each list as an object
        each list object has sub objects for the tasks
        each task has key value pairs for each task definition

        ex:
        listManager:
        {
            listName:
            {
                task1:
                {
                    taskName: ""
                    taskDuration: ""
                }
            },
            listName:
            {
                task1:
                {
                    taskName: ""
                    taskDuration: ""
                }
            }
        }

        json node calls list manager
     */
    public String getJSON(Context context, String fileName)
    {
        String jsonString = "";
        try
        {
            InputStream is = context.getAssets().open("listManager.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
            Log.i("List Manager", "LM: " + jsonString);

        }

        catch(FileNotFoundException e)
        {
            Log.i("List Manager", "LM: UNABLE TO FIND FILE");
        } catch (IOException e)
        {
            Log.i("List Manager", "LM: IO Exception");
        }
        return jsonString;
    }

    public void parseJSON(String jsonString)
    {

        try
        {

            Map listManager = new HashMap<String, ArrayList<Object>>();

            JSONObject obj = new JSONObject(jsonString);
            JSONArray taskListArray = obj.getJSONArray("lists");

            for (int i = 0; i < taskListArray.length(); i++)
            {
                JSONObject listObj =  (JSONObject) taskListArray.get(i);
                JSONArray jsonTasks = listObj.getJSONArray("tasks");

                Log.i("List Manager", "listName: " + listObj.get("listName"));
                ArrayList<Object> tasks = new ArrayList<Object>();


                for(int j = 0; j < jsonTasks.length(); j++)
                {
                    ArrayList<Object> task = new ArrayList<Object>();

                    JSONObject jsonTask = (JSONObject) jsonTasks.get(j);
                    task.add(jsonTask.get("taskName"));
                    task.add(jsonTask.get("taskDuration"));

                    tasks.add(task);

                }
                Log.i("List Manager", "Tasks in : " + listObj.get("listName") + ": " + tasks);

            }
        }
        catch (JSONException e)
        {
            Log.i("List Manager", "LM: JSON Exception" + e.getMessage());
        }
    }
    public void addTaskToList(String task, double duration, String listName)
    {
        //TODO return an arraylist depending on listName
        try
        {
            ArrayList taskDetails = new ArrayList<>();
            taskDetails.add(task);
            taskDetails.add(duration);

            ArrayList<ArrayList<Object>> list = (ArrayList<ArrayList<Object>>) listManager.get(listName);
            list.add(taskDetails);
        }
        catch(NullPointerException e)
        {
            Log.i("List Manager","entered an invalid list name");
        }
    }

    public ArrayList getTaskDetails(String listName, String taskName)
    {
        ArrayList list = (ArrayList) listManager.get(listName);

        if(list.indexOf(taskName) != -1)
            return (ArrayList) list.get(list.indexOf(taskName));
        return null;
    }

    public void removeTaskToList(String task, double duration, String listName)
    {
        try
        {
            ArrayList taskDetails = new ArrayList<>();
            taskDetails.add(task);
            taskDetails.add(duration);

            ArrayList<ArrayList<Object>> list = (ArrayList<ArrayList<Object>>) listManager.get(listName);
            list.remove(taskDetails);
        }
        catch(NullPointerException e)
        {
            Log.i("List Manager","entered an invalid list name");
        }
    }
}

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

public class ListManager {


    public static HashMap<String, HashMap<String, Double>> listManager;

    public ListManager(Context context, String fileName)
    {

        // TODO: if there is a file with all of information, use it to repopulate the lust
        //this.listManager = this.parseListManager(this.getJSON(context, fileName));
        //this.allTasks = this.parseAllTasks(this.getJSON(context, fileName));
        this(context);
    }
    public ListManager(Context context)
    {
        listManager = new HashMap<String, HashMap<String, Double>>();
    }
    //TODO: figure out how to parse information to list
    /*
        Structure:
        HashMap for each list
            list: HashMap with each task and it's average time of completion

        Example:
        {
            "list 1": {
                {
                    "eat breakfast": 30,
                    "clean room": 45
                }
            },

            "list 2": {

            }

        }

    */


    public void addTaskToList(String taskName, double averagedTime, String listName)
    {

         if(this.listManager.containsKey(listName)) //if the list exists
            {
                this.listManager.get(listName).put(taskName, averagedTime); // then find the list and add a new task with the averaged time
            }

    }
    public void removeTaskFromList(String taskName, String listName)
    {

        if(this.listManager.containsKey(listName)) //if the list exists
        {
            this.listManager.get(listName).remove(taskName); // then find the list and remove the desired task
        }

    }
    public Double getTaskTime(String listName, String taskName)
    {
        if(this.listManager.containsKey(listName)) //if the list exists
            {
               if(this.listManager.get(listName).containsKey(taskName))
               {
                   return this.listManager.get(listName).get(taskName);
               }
            }


        return null;
    }



//******************************* Specific to reading and writing from files (Angela's part) *******************************
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

    public Map parseListManager(String jsonString)
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

                ArrayList<Object> tasks = new ArrayList<Object>();


                for(int j = 0; j < jsonTasks.length(); j++)
                {
                    ArrayList<Object> task = new ArrayList<Object>();

                    JSONObject jsonTask = (JSONObject) jsonTasks.get(j);
                    task.add(jsonTask.get("taskName"));
                    task.add(jsonTask.get("taskDuration"));

                    tasks.add(task);
                }
                listManager.put(listObj.get("listName"), tasks);

            }
            return listManager;
        }
        catch (JSONException e)
        {
            Log.i("List Manager", "LM: JSON Exception" + e.getMessage());
        }
        return null;
    }
    public Map parseAllTasks(String jsonString)
    {
        return null;
    }

}

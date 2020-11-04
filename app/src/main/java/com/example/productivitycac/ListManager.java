package com.example.productivitycac;

import android.content.Context;
import android.util.Log;

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
    //CURRENTLY CANNOT FIND FILE
    public static Map listManager = new HashMap<ArrayList<ArrayList<Object>>, String>();
    public ListManager()
    {

        // typecasting obj to JSONObject

    }
    /*
        listManager{ArrayList<E> list};
            ArrayList<E>{[task, duration], [task, duration]};
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

            JSONObject obj = new JSONObject(jsonString);
            String task1 = obj.getJSONObject("listName").getString("task1");
            Log.i("List Manager", "LM: TASK1: " + task1);


            /*
            Object obj = new JSONParser().parse(new FileReader(new File("listManager.json")));

            JSONObject jo = (JSONObject) obj;

            // getting firstName and lastName
            String list = (String) jo.get("listName");
            Log.i("List Manager", list);

             */

        }

        catch(FileNotFoundException e)
        {
            Log.i("List Manager", "LM: UNABLE TO FIND FILE");
        } catch (IOException e)
        {
            Log.i("List Manager", "LM: IO Exception");
        } catch (JSONException e) {
            Log.i("List Manager", "LM: JSON Exception");
        }
        return jsonString;
    }

    public void parseJSON()
    {
        /*Gson gson = new Gson();
        Type listUserType = new TypeToken<List<User>>() { }.getType();
         */
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

package com.example.productivitycac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MasterTaskManager
{
    //Todo: discuss having reading and writing in this class, and use list manager to just add stuff to UI
    public static ListManager listManager;
    public static HashMap<String, ArrayList<Double>> allTasks;

    public MasterTaskManager()
    {
        allTasks = new HashMap<String, ArrayList<Double>>();
    }

    public void addTask(String taskName, Double time,String listName)
    {
        if(this.allTasks.containsKey(listName))
        {
            if(this.listManager.containsTask(taskName)) //if the task already exists, add it to the list manager after facotring the newest estimate into the predicted time
            {
                ArrayList<Double> timesForTask = allTasks.get(taskName);
                timesForTask.add(time);
                this.listManager.addTaskToList(taskName, average(timesForTask),listName);
                return;
            }
            else // if the task is new, add it to the allTasks list and then the list manager
            {
                allTasks.put(taskName, new ArrayList<Double>());
                allTasks.get(taskName).add(time);

                this.listManager.addTaskToList(taskName, time,listName);
            }
        }
    }

    public void addTask(String taskName,String listName)
    {
        if(this.allTasks.containsKey(taskName))
        {
            this.listManager.removeTaskFromList(taskName, listName);

        }
    }

    public Double average(ArrayList<Double> taskTimes)
    {
        Double total = new Double (0);
        for(Double time: taskTimes)
            total += time;

        return total / taskTimes.size();
    }

    // Saves all task information to a formatted tab file
    //Saved in this format
    /*
    taskName1 \t time1 \t time2\ etc. \t \n
    taskName2 \t time1 \t time2\ etc. \t \n
     */
    public void saveToTaskFile(String filePath) throws IOException
    {
        FileWriter writer = new FileWriter(filePath);

        writer.write(tabSeparateContents());

        writer.close();
    }

    // Returns comma separated information of all tasks
    public String tabSeparateContents()
    {
        String contents = "";
        Set<String> taskNames = this.allTasks.keySet();
        Object[] keyArray = taskNames.toArray();
        ArrayList<String> keyArrayList = new ArrayList<String>();
        for(int i = 0; i < keyArray.length; i++)
        {
            keyArrayList.add((String) keyArray[i]);
        }

        for(int i = 0; i < keyArrayList.size(); i++)
        {
            String keyName = keyArrayList.get(i);

            contents = contents + keyName + "\t";

            for(int j = 0; j < allTasks.get(keyName).size(); j++)
            {
                contents = contents + allTasks.get(keyName).get(j) + "\t";
            }
            contents = contents + "\n";
        }
        return contents;
    }


    // Reads information from the tab file
    // Inputs information into the arraylists to be displayed when application opens
    public void readfromTaskFile(String filePath) throws FileNotFoundException
    {
        File myFile = new File(filePath);
        Scanner reader = new Scanner(myFile);

        while(reader.hasNextLine())
        {
            String nextLine = reader.nextLine();
            try
            {
                readTaskLine(nextLine);
            }
            catch (Exception e) {}
        }

        reader.close();
    }

    // Reads tab separated information and inputs information into correct hashmap
    public void readTaskLine(String singleFileLine) throws IOException
    {
        // The first item in the list is always the name of the task
        int firstTabIndex = singleFileLine.indexOf("\t");
        String taskName = singleFileLine.substring(0,firstTabIndex);

        ArrayList<Double> times = new ArrayList<Double>();
        String remainingTasks = singleFileLine.substring(firstTabIndex + 1);

        //Turn string into char array to be read one at a time
        char[] stringCharacters = new char[remainingTasks.length()];

        for (int i = 0; i < remainingTasks.length(); i++) {
            stringCharacters[i] = remainingTasks.charAt(i);
        }

        String timeString = "";

        for(int i = 0; i < stringCharacters.length; i++)
        {
            Character character = stringCharacters[i];
            timeString = timeString + character;

            if (character.equals('\t'))
            {
                Double time = Double.parseDouble(timeString);
                times.add(time);
                timeString = "";
            }
        }

        allTasks.put(taskName, times);

    }
}

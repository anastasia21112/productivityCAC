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
            if(this.listManager.containsTask(taskName)) //if the task already exists, add it to the list manager after factoring the newest estimate into the predicted time
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

    // Saves all master task information to a formatted tab file
    //Format of saved file
    /*
    taskName1 \t time1 \t time2 \t etc. \n
    taskName2 \t time1 \t time2 \t etc. \n
     */
    public void saveToMasterTaskFile(String filePath) throws IOException
    {
        FileWriter writer = new FileWriter(filePath);

        writer.write(tabSeparateMasterTask());

        writer.close();
    }

    public String tabSeparateMasterTask()
    {
        String tabContents = "";
        Set<String> allTaskNames = this.allTasks.keySet();
        Object[] keyArray = allTaskNames.toArray();
        ArrayList<String> keyArrayList = new ArrayList<String>();
        for(int i = 0; i < keyArray.length; i++)
        {
            keyArrayList.add((String) keyArray[i]);
        }

        for(int i = 0; i < keyArrayList.size(); i++)
        {
            String taskName = keyArrayList.get(i);

            tabContents = tabContents + taskName + "\t";

            for(int j = 0; j < allTasks.get(taskName).size(); j++)
            {

                tabContents = tabContents + allTasks.get(taskName).get(j);
            }
            tabContents = tabContents + "\n";
        }
        return tabContents;
    }

    // Reads information from the tab file
    // Inputs information into the master task manager to be displayed when application opens
    public void readfromTabFile(String filePath) throws FileNotFoundException
    {
        File myFile = new File(filePath);
        Scanner reader = new Scanner(myFile);

        while(reader.hasNextLine())
        {
            String nextLine = reader.nextLine();

            try
            {
                readTabLine(nextLine);
            }
            catch (Exception e) {}
        }

        reader.close();
    }

    //Add single key input mapped to arraylist containing times
    public void readTabLine(String singleFileLine) throws IOException
    {
        // The first item in the list is always the name of the task
        int firstTabIndex = singleFileLine.indexOf("\t");
        String taskName = singleFileLine.substring(0,firstTabIndex);

        ArrayList<Double> times = new ArrayList<Double>();
        String remainingTimes = singleFileLine.substring(firstTabIndex + 1);

        //Turn string into char array to be read one at a time
        char[] stringCharacters = new char[remainingTimes.length()];

        for (int i = 0; i < remainingTimes.length(); i++)
        {
            stringCharacters[i] = remainingTimes.charAt(i);
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

        this.allTasks.put(taskName, times);
    }

}

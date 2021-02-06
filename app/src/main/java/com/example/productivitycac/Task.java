package com.example.productivitycac;

import java.util.ArrayList;

public class Task
{
    private String taskName;
    private ArrayList<Double> taskTimes;

    public Task (String name)
    {
        this.taskName = name;
        taskTimes = new ArrayList<Double>();
    }

    public void addTime(Double time)
    {
        taskTimes.add(time);
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String name)
    {
        this.taskName = name;
    }

    public ArrayList<Double> getTaskTime()
    {
        return taskTimes;
    }

    public void setTaskTime(ArrayList<Double> times)
    {
        this.taskTimes = times;
    }
}

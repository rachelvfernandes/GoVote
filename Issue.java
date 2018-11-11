package com.example.razzle.govote;

public class Issue
{
    private String name;
    private String description;
    private int support;

    public Issue(String n, String d, int s)
    {
        name = n;
        description = d;
        support = s;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getSupport()
    {
        return support;
    }
}
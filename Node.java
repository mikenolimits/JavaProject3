package com.company;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by michaelkantor on 4/9/15.
 */
/*  Class Node  */
public class Node
{
    protected Node link;
    public String firstName;
    public String lastName;
    public String number;
    public String era;

    public Map<String,String> container;

    /*  Constructor  */
    public Node()
    {
        link = null;
    }
    /*  Constructor  */
    public Node(Map<String,String> values,Node n)
    {
        this.container = values;
        link = n;
    }

    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }

    /*  Function to get data from current Node  */
    public Map<String,String> getData()
    {
        return this.container;
    }

}
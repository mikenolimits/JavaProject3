package com.company;

/**
 * Created by michaelkantor on 4/9/15.
 */

import java.lang.reflect.Array;
import java.util.List;
import java.util.*;
import java.util.ArrayList;

public class LinkedList {
    public List<Fielder> fielders;
    public List<Pitcher> pitchers;
    public List<Player> all;

    protected Node start;
    public int size;


    public LinkedList() {
        start = null; // Start is a NODE
        size = 0;
    }

    /*  Function to check if list is empty  */
    public boolean isEmpty() {
        return start == null;
    }

    /*  Function to check size of list  */
    public int getSize() {
        return size;
    }

    /*  Function to insert an element  */
    public void insert(Map<String, String> player) {
        Node nptr, ptr, tmp = null;


        nptr        = new Node(player, null);

        boolean ins = false;

        int currentNumber = Integer.valueOf(player.get("number"));

        if (start == null) {
            // first round, IT IS NULL! as declared above
            start = nptr;
        } else if (currentNumber <= Integer.valueOf(start.getData().get("number"))) {

            nptr.setLink(start);
            start = nptr;

        } else {
            tmp = start;
            ptr = start.getLink();

            while (ptr != null) {
                boolean lessThan    = Integer.valueOf(player.get("number")) >= Integer.valueOf(tmp.getData().get("number"));
                boolean greaterThan = Integer.valueOf(player.get("number")) <= Integer.valueOf(ptr.getData().get("number"));


                if (lessThan && greaterThan) {
                    tmp.setLink(nptr);
                    nptr.setLink(ptr);
                    ins = true;
                    break;
                } else {
                    tmp = ptr;
                    ptr = ptr.getLink();
                }
            }

            if (!ins) {
                tmp.setLink(nptr);
            }

        }
        size++;
    }

    public void sort() {
        //  	System.out.print("Sorted Singly Linked List:\n");


        fielders = new ArrayList<Fielder>();
        pitchers = new ArrayList<Pitcher>();
        all      = new ArrayList<Player>();


        if (size == 0) {
            return;
        }

        Node ptr = start.getLink();

        iterateList(start);

        while (ptr.getLink() != null) {

            ptr = iterateList(ptr);
        }
        iterateList(ptr);


    }

    private Node iterateList(Node ptr) {
        String number      = String.valueOf(ptr.getData().get("number"));
        String lastName    = ptr.getData().get("lastName");
        String firstName   = ptr.getData().get("firstName");
        String battingAvg  = String.valueOf(ptr.getData().get("battingAvg"));
        char playerType    = ptr.getData().get("playerType").charAt(0);

        switch (playerType) {
            case 'P':

                String  era            = ptr.getData().get("era");
                Pitcher currentPitcher = new Pitcher(battingAvg, number, lastName, firstName, era);
                pitchers.add(currentPitcher);
                break;

            case 'F':

                Fielder currentFielder = new Fielder(battingAvg, number, lastName, firstName);
                fielders.add(currentFielder);
                break;

            default:
                throw new IllegalArgumentException("The Type Doesnt Exist...");
        }
        ptr = ptr.getLink();
        return ptr;
    }

}
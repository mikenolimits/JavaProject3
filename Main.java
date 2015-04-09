package com.company;

import java.awt.*;
import java.util.List;

public class Main {

    public static GUI WordFrame;
    public static WordSorter Reader;
    public static LinkedList list;


    public static void main(String[] args) {

        WordFrame     = new GUI("Project 3",1000,4000);
        Reader        = new WordSorter("players.txt");


        list     =  Reader.getWords();
        list.sort();

        for (int i = 0; i < Reader.unorganizedList.size(); i++) {

            Player player        =  Reader.unorganizedList.get(i);
            String currentLine   =  player.number + "," + player.firstName + "," + player.lastName + "," + player.battingAvg + "\r\n";
            WordFrame.text1.append(currentLine);
        }
        Reader.unorganized = false;


        WordFrame.organizeColumn(list,2);
        WordFrame.organizeColumn(list,3);
    }

}

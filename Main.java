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
        //List<Player> rightColumn =  Reader.alphabetize();

        WordFrame.organizeColumn(list, 1);
        //WordFrame.organizeColumn(rightColumn,WordFrame.text2);
    }

}

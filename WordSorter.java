package com.company;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.List;
import java.util.*;
import java.util.ArrayList;

/**
 * Created by michaelkantor on 3/2/15.
 */
public class WordSorter {

    protected TextFileInput reader;

    protected String        location;
    protected LinkedList    players;

    protected ArrayList<Player> unorganizedList;

    public boolean unorganized = true;


    /*
     Basic Constructor For WordSorting Object. It basically
     fills up our Words List from the TextFile.

     */

    public WordSorter(String location){

        this.location = location;
        this.players  = new LinkedList();
        this.unorganizedList = new ArrayList<Player>();

        setWords();
    }


    /*
       Setter for words that iterates through the text file specified in the constructor
     */

    public void setWords(){

        System.out.println("reading words....");

        reader            = new TextFileInput(location);

        String current;


        while( (current = reader.readLine()) != null) {

            String [] allWordsInLine = current.split(",");

                insertToLinkedList(allWordsInLine);

                Player currentPlayer = new Player(allWordsInLine[0].charAt(0),allWordsInLine[4],allWordsInLine[1],allWordsInLine[3],allWordsInLine[2]);
                unorganizedList.add(currentPlayer);

        }

    }

    private void insertToLinkedList(String[] allWordsInLine) {
        Map<String,String> currentPlayer = new HashMap<String,String>();


        String playerType = allWordsInLine[0];


        currentPlayer.put("playerType",playerType);
        currentPlayer.put("number",allWordsInLine[1]);
        currentPlayer.put("lastName",allWordsInLine[2]);
        currentPlayer.put("firstName",allWordsInLine[3]);
        currentPlayer.put("battingAvg",allWordsInLine[4]);


        switch (playerType.charAt(0)){
            case 'F':
                players.insert(currentPlayer);
                break;
            case 'P':
                currentPlayer.put("era",allWordsInLine[5]);
                players.insert(currentPlayer);
                break;
            default:
                throw new IllegalArgumentException("The Type Doesnt Exist...");
        }
    }

    public LinkedList getWords(){

        return players;
    }


    public void setLocation(String location) {

        this.location = location;
    }

}
